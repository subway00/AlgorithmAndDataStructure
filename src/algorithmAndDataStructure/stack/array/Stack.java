package algorithmAndDataStructure.stack.array;

public class Stack<T> {
	
	private T[] stack;
	private int count;

	public Stack() {
		stack = (T[]) new Object[1];
	}
	
	//we just have to add the new item to the end of the array O(1)
	public void push(T newData) {
		
		
		if (count == stack.length) {
			resize(2*count);
		}
		stack[count++] = newData;
	}
	
	//return(removes) the last item we have inserted O(1)
	public T pop() {
		if(isEmpty()) return null;
		
		T item = stack[--count];
		//obsolete reference - avoid memory leak
		stack[count] = null;
		
		if(count > 0 && count == stack.length / 4) {
			resize(stack.length/2);
		}
		return item;
	}
	
	//O(1)
	public boolean isEmpty() {
		return count == 0;
	}
	
	//size method in O(1)
	public int size() {
		return count;
	}
	private void resize(int capacity) {
		System.out.println("Need to resize the array...");
		T[] stackCopy = (T[]) new Object[capacity];
		
		for (int i=0 ; i < count ; i++) {
			stackCopy[i] = stack[i];
		}
		
		stack = stackCopy;
	}
}
