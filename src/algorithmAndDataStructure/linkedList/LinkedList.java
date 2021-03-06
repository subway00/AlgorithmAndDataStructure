package algorithmAndDataStructure.linkedList;

public class LinkedList <T extends Comparable<T>> implements List<T>{
	private Node<T> rootNode;
	private int numOfItems;
	@Override
	public void insert(T data) {
		if (rootNode == null) {
			rootNode = new Node(data);
		} else {
			insertBeginning(data);
		}
	}
	// we just have to update the reference O(1)
	private void insertBeginning(T data) {
		Node<T> newNode = new Node(data);
		newNode.setNextNode(rootNode);
		rootNode = newNode;
	}
	
	private void insertEnd(T data, Node<T> node) {
		
		if(node.getNextNode() != null) {
			insertEnd(data, node.getNextNode());
		} else {
			Node<T> newNode = new Node(data);
			node.setNextNode(newNode);
		}
	}
	
	@Override
	public void remove(T data) {
		
		if (rootNode == null) return;
		
		if(rootNode.getData().compareTo(data) == 0) {
			rootNode = rootNode.getNextNode();
		} else {
			remove(data, rootNode, rootNode.getNextNode());
		}
	}
	
	// because linkedList can not get the previous node, so we need two parameter
	private void remove(T data, Node<T> previousNode, Node<T> actualNode) {
		
		while(actualNode != null) {
			if(actualNode.getData().compareTo(data) == 0) {
				numOfItems --;
				previousNode.setNextNode(actualNode.getNextNode());
				actualNode = null;
				return;
			}
			
			previousNode = actualNode;
			actualNode = actualNode.getNextNode();
		}
	}
	@Override
	public void traverse() {
		if (rootNode == null) return;
		
		Node<T> actualNode = rootNode;
		
		while(actualNode != null) {
			System.out.println(actualNode.toString());
			actualNode = actualNode.getNextNode();
		}
	}

	@Override
	public int size() {
		return numOfItems;
	}

}
