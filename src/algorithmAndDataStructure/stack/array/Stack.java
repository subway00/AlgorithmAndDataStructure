package algorithmAndDataStructure.stack.array;

public class Stack<T> {
	
	private T[] stack;
	private int count;

	public Stack() {
		stack = (T[]) new Object[1];
	}
	
	//We just have to add the new item to the end of the array O(1)
	public void push(T newData) {
		//Arrays are not dynamic data structure
		//We have to resize the underlying array if necessary
		//If there are too many items : we double the size of the array
		//If there are too few items: then we decrease (shrink) the array
		if (count == stack.length) {
			resize(2*count);
		}
		stack[count++] = newData;
	}
	
	//Return(removes) the last item we have inserted O(1)
	public T pop() {
		if(isEmpty()) return null;
		
		T item = stack[--count];
		//Obsolete reference - avoid memory leak
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
	
	//Size method in O(1)
	public int size() {
		return count;
	}

	//This is the bottleneck of the application O(N)
	private void resize(int capacity) {
		System.out.println("Need to resize the array...");
		T[] stackCopy = (T[]) new Object[capacity];

		//Copy the item one by one
		for (int i=0 ; i < count ; i++) {
			stackCopy[i] = stack[i];
		}
		
		stack = stackCopy;
	}
}
