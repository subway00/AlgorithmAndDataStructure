package algorithmAndDataStructure.redblackTree;


public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

	private Node<T> root;

	@Override
	public void insert(T data) {
		// this is when we insert the first node into the BST (parent is null)
		if (root == null) {
			root = new Node(data, null);
		} else {
			// there are already items in the BST
			insert(data, root);
		}
	}

	private void insert(T data, Node<T> node) {
		// this is the case when the data is SMALLER than the value in the node
		// GO TO THE LEFT SUBTREE
		if (node.getData().compareTo(data) > 0) {
			// there is a valid (not NULL) left child so we go there
			if (node.getLeftChild() != null) {
				insert(data, node.getLeftChild());
			}
			// the left child is a NULL so we create a left child
			else {
				Node<T> newNode = new Node<>(data, node);
				node.setLeftChild(new Node(data, node));
				// WE HAVE TO CHECK whether the red black properties are violated or not
				settleViolations(newNode);
			}
			// this is the case when the data is GREATER than the value in the node
			// GO TO THE RIGHT SUBTREE
		} else {
			// there is a valid (not NULL) right child so we go there
			
			if (node.getRightChild() != null) {
				insert(data, node.getRightChild());
			} 
			// the right child is a NULL so we create a right child
			else {
				// WE HAVE TO CHECK whether the red black properties are violated or not
				Node<T> newNode = new Node<>(data, node);
				node.setRightChild(newNode);
				settleViolations(newNode);
			}

			// WE HAVE TO CHECK whether the red black properties are violated or not
		}
	}

	@Override
	public void remove(T data) {
		// TODO Auto-generated method stub

	}

	@Override
	public void traversal() {

		if (root != null)
			traversal(root);
	}

	private void traversal(Node<T> node) {

		if (node.getLeftChild() != null) {
			traversal(node.getLeftChild());
		}
		System.out.print(node + " - ");

		if (node.getRightChild() != null) {
			traversal(node.getRightChild());
		}
	}
	
	//takes at most O(logN)
	private void settleViolations(Node<T> node) {
		Node<T> parentNode = node.getParentNode();
		Node<T> grandParentNode = node.getParentNode().getParentNode();
		
		//we have to check the violations up to the root node
		while(node != root && isRed(node) && isRed(node.getParentNode())) {
			
			//parent is a left child of it's parent (so the grandparent)
			if(parentNode == grandParentNode.getLeftChild()) {
				
				Node<T> uncle = grandParentNode.getRightChild();
			
				//case 1.) and case 4.) RECOLORING
				if( uncle != null && isRed(uncle)) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
				} else {
					// case2.)
					if (node == parentNode.getRightChild()) {
						leftRotation(parentNode);
						//update the reference we keep going up to the root node
						node = parentNode;
						parentNode = grandParentNode;
					}
					
					// case3.) rotation on the grandparent + parent and grandparent switch color
					rightRotation(grandParentNode);
					System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
					//swap the color of the parent and the grandparent
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					//update the references because we keep going to the root node
					node = parentNode;
				}
			} else {
				//parent is a right child of it's parent (so the grandparent)
				Node<T> uncle = grandParentNode.getLeftChild();
				
				//case 1.) and case 4.) symmetric partner
				if( uncle != null && isRed(uncle)) {
					grandParentNode.setColor(NodeColor.RED);
					parentNode.setColor(NodeColor.BLACK);
					uncle.setColor(NodeColor.BLACK);
					node = grandParentNode;
				} else {
					// case 2.) symmetric partner
					if( node == parentNode.getLeftChild()) {
						rightRotation(parentNode);
						node = parentNode;
						parentNode = grandParentNode;
					}
					
					//case 3.) symmetric partner
					leftRotation(grandParentNode);
					System.out.println("Recoloring " +parentNode+ " + " + grandParentNode);
					NodeColor tempColor = parentNode.getColor();
					parentNode.setColor(grandParentNode.getColor());
					grandParentNode.setColor(tempColor);
					node = parentNode;
				}
			}
		}
		
		// root node can not be RED so we have to recolor if necessary
		if(isRed(root)) {
			System.out.println("Recoloring the root to black...");
			root.setColor(NodeColor.BLACK);
		}
	}
	
	private boolean isRed(Node<T> node) {
		if(node == null) return false;
		
		return node.getColor() == NodeColor.RED;
	}
	
	public void rightRotation(Node<T> node) {
		System.out.println("Rotation right on node " + node);
		//this is the new root node after rotation (node B)
		Node<T> tempLeftChild = node.getLeftChild();
		//Node c
		Node<T> grandChild = tempLeftChild.getRightChild();
		
		//make the rotation - the new root node will be the tempLeftChild
		tempLeftChild.setRightChild(node);
		node.setLeftChild(grandChild);
		
		//we have to handle the grandChild
		if(grandChild != null) {
			grandChild.setParentNode(node);
		}
		
		//we have to handle the parents for the node
		Node<T> tempParent = node.getParentNode();
		node.setParentNode(tempLeftChild);
		tempLeftChild.setParentNode(tempParent);
		
		//we have to handle the parent
		if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getLeftChild() == node) {
			tempLeftChild.getParentNode().setLeftChild(tempLeftChild);
		}
		
		if(tempLeftChild.getParentNode() != null && tempLeftChild.getParentNode().getRightChild() == node) {
			tempLeftChild.getParentNode().setRightChild(tempLeftChild);
		}
		
		//no parent after rotation because it has become the root node
		if(node == root) root = tempLeftChild;
		
	}
	
	private void leftRotation(Node<T> node) {
		System.out.println("Rotation left on node " + node);
		//that is the new root node after rotation(node A)
		Node<T> tempRightChild = node.getRightChild();
		//(node C)
		Node<T> grandChild = tempRightChild.getLeftChild();
		
		//make the rotation
		tempRightChild.setLeftChild(node);
		node.setRightChild(grandChild);
		
		//we have to handle the grandChild
		if(grandChild != null) {
			grandChild.setParentNode(node);
		}
		
		//we have to handle the parent of the node
		Node<T> tempParent = node.getParentNode();
		node.setParentNode(tempRightChild);
		tempRightChild.setParentNode(tempParent);
		
		//we have to handle the parent
		if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getLeftChild() == node) {
			tempRightChild.getParentNode().setLeftChild(tempRightChild);
		}
		
		if(tempRightChild.getParentNode() != null && tempRightChild.getParentNode().getRightChild() == node) {
			tempRightChild.getParentNode().setRightChild(tempRightChild);
		}
		
		//no parent after rotation because it has become the root node
		if(node == root) root = tempRightChild;
		
	}
}
