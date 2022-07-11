package algorithmAndDataStructure.stack.linkedList;

public class App {
	public static void main(String[] args) {
		
		Stack<String> names = new Stack<>();
		
		names.push("Adam");
		names.push("Ana");
		names.push("Kevin");
		names.push("Michael");

		System.out.println(names.peek());

		while (!names.isEmpty()) {
			System.out.println(names.pop());
		}
	}
}
