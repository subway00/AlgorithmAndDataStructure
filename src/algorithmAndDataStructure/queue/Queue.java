package algorithmAndDataStructure.queue;

public class Queue <T extends Comparable<T>>{
	
	private Node<T> firstNode;
	private Node<T> lastNode;
	private int count;
	
	public boolean isEmpty() {
		return this.firstNode == null;
	}
	
	public int count() {
		return this.count;
	}
	
	//O(1)  insert item, because use lastNode to store so it can achieve constant time complexity 
	public void enqueue(T newData) {
		
		this.count++;
		
		Node<T> oldLastNode = this.lastNode;
		this.lastNode = new Node(newData);
		this.lastNode.setNextNode(null);
		
		if(firstNode == null) {
			firstNode = lastNode;
		} else {
			oldLastNode.setNextNode(lastNode);
		}
	}
	
	//O(1) remove item
	public T dequeue() {
		count --;
		
		T dataToDequeue = this.firstNode.getData();
		this.firstNode = this.firstNode.getNextNode();
		
		if(isEmpty()) {
			this.lastNode = null;
		}
		
		return dataToDequeue;
	}
}
