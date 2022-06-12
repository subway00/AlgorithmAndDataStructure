package algorithmAndDataStructure.doublyLinkedList;

public class DoublyLinkedList <T extends Comparable<T>>{
	private Node<T> head;
	private Node<T> tail;
	
	public void insert(T data) {
		Node<T> newNode = new Node(data);
		
		//this is the first item in the doubly linked list
		if(tail == null) {
			// both of the pointes are pointing to the new node
			head = new Node(data);
			tail = new Node(data);
		} else {
			// we have to insert the new item to the end of the list
			// we just have to manipulating the tail node and its reference in O(1)
			newNode.setPreviousNode(tail);
			tail.setNextNode(newNode);
			tail = newNode;
		}
	}
	
	public void traversForward() {
		Node<T> actualNode = head;
		
		while(actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getNextNode();
		}
	}
	
	public void traversBackward() {
		Node<T> actualNode = tail;
		
		while(actualNode != null) {
			System.out.println(actualNode);
			actualNode = actualNode.getPreviousNode();
		}
	}
}
