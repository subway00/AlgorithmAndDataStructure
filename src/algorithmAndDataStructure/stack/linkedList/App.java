package algorithmAndDataStructure.stack.linkedList;

public class App {
	public static void main(String[] args) {
		
		Stack<String> names = new Stack<>();
		
		names.push("Adam");
		names.push("Ana");
		names.push("Kevin");
		
		while (!names.isEmpty()) {
			System.out.println(names.pop());
		}
	}
}
