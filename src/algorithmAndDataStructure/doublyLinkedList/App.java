package algorithmAndDataStructure.doublyLinkedList;

public class App {
	public static void main(String[] args) {
		DoublyLinkedList<String> names = new DoublyLinkedList<String>();
		
		names.insert("Adam");
		names.insert("Kevin");
		names.insert("Ana");
		names.insert("Daniel");
		
		names.traversBackward();
	}
}
