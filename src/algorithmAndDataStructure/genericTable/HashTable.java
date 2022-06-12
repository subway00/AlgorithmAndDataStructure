package algorithmAndDataStructure.genericTable;

public class HashTable<Key, Value> {
	private Key[] keys;
	private Value[] values;
	private int numOfItems;
	private int capacity;	//it is the maximum of items that can be inserted in the table;
							//numOfItems <= capacity
	
	public HashTable() {
		this.keys = (Key[]) new Object[Constants.TABLE_SIZE];
		this.values = (Value[]) new Object[Constants.TABLE_SIZE];
		this.capacity = Constants.TABLE_SIZE;
		this.numOfItems = 0;
	}
	
	public HashTable(int newCapacity) {
		this.keys = (Key[]) new Object[newCapacity];
		this.values = (Value[]) new Object[newCapacity];
		this.capacity = newCapacity;
		this.numOfItems = 0;
	}
	
	// O(1)
	public int size() {
		return this.numOfItems;
	}
}
