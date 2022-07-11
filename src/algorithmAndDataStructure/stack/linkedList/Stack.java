package algorithmAndDataStructure.stack.linkedList;

public class Stack <T>{
	
	private Node<T> head;
	private int count;

	// O(1)
	public void push(T data) {
		count ++;
		
		if (head == null) {
			head = new Node(data);
		} else {
			Node<T> oldHead = head;
			head = new Node(data);
			head.setNextNode(oldHead);
		}
		
	}
	// Remove the last item we have inserted O(1)
	public T pop() {
		if (head == null) return null;
		
		T item = head.getData();
		head = head.getNextNode();
		count --;
		return item;
	}

	public T peek() {
		return head.getData();
	}

	// O(1)
	public int size() {
		return count;
	}
	// O(1)
	public boolean isEmpty() {
		return count == 0;
	}
}
