package algorithmAndDataStructure.AVLTrees;

public class App {
	
	public static void main(String[] args) {
		
		Tree<Integer> avl = new AVLTree<>();
		
		avl.insert(3);
		avl.insert(4);
		avl.insert(5);
		
		avl.traversal();
	}
}
