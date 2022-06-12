package algorithmAndDataStructure.stack.linkedList;

public class Node <T>{
	
	private T data;
	//that is why this implementataion has some additional memory complexity
	private Node<T> nextNode;
	
	public Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node<T> nextNode) {
		this.nextNode = nextNode;
	}
	
	@Override
	public String toString() {
		return "" + data;
	}
}
