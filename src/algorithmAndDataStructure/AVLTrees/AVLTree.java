package algorithmAndDataStructure.AVLTrees;


public class AVLTree<T extends Comparable<T>> implements Tree<T> {
	private Node<T> root;

	@Override
	public void insert(T data) {
		// TODO Auto-generated method stub
		if (root == null) {
			root = new Node(data, null);
		} else {
			insert(data, root);
		}
	}

	private void insert(T data, Node<T> node) {

		if (node.getData().compareTo(data) > 0) {
			if (node.getLeftChild() == null) {
				node.setLeftChild(new Node(data, node));
			} else {
				insert(data, node.getLeftChild());
			}
		} else {
			if (node.getRightChild() == null) {
				node.setRightChild(new Node(data, node));
			} else {
				insert(data, node.getRightChild());
			}
		}
		//this node is the parent
		updateHeight(node);
		settleViolations(node);
	}

	@Override
	public void remove(T data) {
		if (root != null) remove(data, root);
	}

	private void remove(T data, Node<T> node) {
		if(node == null) return;
		
		//fist we have to search for the item we want to remove
		if(data.compareTo(node.getData()) < 0) {
			remove(data, node.getLeftChild());
		} else if(data.compareTo(node.getData()) > 0) {
			remove(data, node.getRightChild());
		} else {
			//we have found the item we want to remove
			
			//CASE 1) 
			//if the node is a left node
			if(node.getLeftChild()==null && node.getRightChild()==null) {
				System.out.println("remove the leaf node....");
				//whether the node is a left child or right child
				Node<T> parent = node.getParentNode();
				
				if(parent!=null && parent.getLeftChild()==node) {
					parent.setLeftChild(null);
				} else if(parent != null && parent.getRightChild() == node) {
					parent.setRightChild(null);
				}
				
				if(parent == null) root = null;
				
				node = null;
				
				updateHeight(parent);
				settleViolations(parent);
			}
			
			// CASE 2) when we remove items with a single child
			// a single right child
			else if(node.getLeftChild() == null && node.getRightChild() != null) {
				System.out.println("remove the node with single right child....");
				Node<T> parent = node.getParentNode();
				
				//the node is a left child
				if(parent != null && parent.getLeftChild()==node) {
					parent.setLeftChild(node.getRightChild());
				} else if(parent != null && parent.getRightChild() == node) {
					parent.setRightChild(node.getRightChild());
				}
				
				//when we deal with the root node
				if(parent == null) {
					root = node.getRightChild();
				}
				
				//have to update the right child's parent
				node.getRightChild().setParentNode(parent);
				node = null;
				
				updateHeight(parent);
				settleViolations(parent);
			}
			
			//it is approximately the same case CASE 2) but we have to deal with the left child
			else if(node.getLeftChild() != null && node.getRightChild() == null) {
				System.out.println("remove the node with single left child....");
				Node<T> parent = node.getParentNode();
				
				//the node is a left child
				if(parent != null && parent.getLeftChild()==node) {
					parent.setLeftChild(node.getLeftChild());
					//the node is a right child
				} else if(parent != null && parent.getRightChild() == node) {
					parent.setRightChild(node.getLeftChild());
				}
				
				//when we deal with the root node
				if(parent == null) {
					root = node.getLeftChild();
				}
				
				//have to update the right child's parent
				node.getLeftChild().setParentNode(parent);
				node = null;
				
				updateHeight(parent);
				settleViolations(parent);
			}
			
			//remove two children
			else {
				System.out.println("remove the a node with 2 children....");
				//find the predecessor (max item in the left subtree)
				Node<T> predecessor = getPredecessor(node.getLeftChild());
				
				//swap 	just the value !!!
				T temp = predecessor.getData();
				predecessor.setData(node.getData());
				node.setData(temp);
				
				//we have to call the delete method recursively on the predecessor
				remove(data, predecessor);
				//we do not have to update height and settleViolations because we are going to end up with leaf node
			}
		}
	}

	private Node<T> getPredecessor(Node<T> node) {
		if(node.getRightChild() != null) {
			return getPredecessor(node.getRightChild());
		}
		return node;
	}
	@Override
	public void traversal() {
		
		if (root == null) return;
		
		traversal(root);
	}
	
	private void traversal(Node<T> node) {
	
		if(node.getLeftChild() != null) {
			traversal(node.getLeftChild());
		}
		System.out.print(node + " - ");
		
		if(node.getRightChild() != null) {
			traversal(node.getRightChild());
		}
	}
	
	private void settleViolations(Node<T> node) {
		
		//we have to check up to root node O(logN)
		while(node != null) {
			updateHeight(node);
			settleViolationHelper(node);
			node = node.getParentNode();
		}
	}
	private void settleViolationHelper(Node<T> node) {
		
		int balance = getBalance(node);
		
		//OK, we know the tree is LEFT HEAVY BUT it can be left-right heavy or left-left heavy
		if(balance > 1) {
			//left right heavy situation: left rotation
			if(getBalance(node.getLeftChild()) < 0) {
				leftRotation(node.getLeftChild());
			}
			//doubly left heavy situation then just a single right rotation is needed
			//this is the right rotation
			rightRotation(node);
		}
		//OK, we know the tree is Right HEAVY BUT it can be right-left heavy or right-right heavy	
		if(balance < -1) {
			//right-left heavy situation: right rotation
			if(getBalance(node.getRightChild()) > 0) {
				rightRotation(node.getRightChild());
			}
			//doubly right heavy situation then just a singel left rotation is needed
			//this is the left rotation
			leftRotation(node);
			
		}
	}

	@Override
	public T getMin() {
		// TODO Auto-generated method stub
		if (root == null) return null;
		
		return getMin(root);
	}
	
	private T getMin(Node<T> node) {
		if(node.getLeftChild() != null) {
			return getMin(node.getLeftChild());
		}
		return node.getData();
	}
	
	@Override
	public T getMax() {
		if (root == null) {
			return null;
		}
		
		return getMax(root);
	}

	public T getMax(Node<T> node) {
		
		if(node.getRightChild() != null) {
			return getMax(node.getRightChild());
		}
		return node.getData();
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
		
		//after rotations the height parameters can change
		updateHeight(node);
		updateHeight(tempLeftChild);
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
		
		//after rotation the height parameter can change
		updateHeight(node);
		updateHeight(tempRightChild);
	}
	
	//update the height of a given node
	private void updateHeight(Node<T> node) {
		node.setHeight(Math.max(height(node.getLeftChild()), height(node.getRightChild()))+1);
	}
	
	//it returns the height parameter for the given node
	private int height(Node<T> node) {
		if(node == null) return -1;
		return node.getHeight();
	}
	
	//balance factor to decide the left heavy or right heavy cases
	private int getBalance(Node<T> node) {
		
		if(node == null) return 0;
		return height(node.getLeftChild()) - height(node.getRightChild());
	}
}
