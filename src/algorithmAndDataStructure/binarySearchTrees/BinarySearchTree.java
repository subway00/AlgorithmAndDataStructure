package algorithmAndDataStructure.binarySearchTrees;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {
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
			// the left child is a NULL so we create a left child
			if (node.getLeftChild() == null) {
				node.setLeftChild(new Node(data, node));
			} 
			// there is a valid (not NULL) left child so we go there
			else {
				insert(data, node.getLeftChild());
			}
		// this is the case when the data is GREATER than the value in the node
		// GO TO THE RIGHT SUBTREE
		} else {
			// the right child is a NULL so we create a right child
			if (node.getRightChild() == null) {
				node.setRightChild(new Node(data, node));
			// there is a valid (not NULL) right child so we go there
			} else {
				insert(data, node.getRightChild());
			}
			
		}
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
}
