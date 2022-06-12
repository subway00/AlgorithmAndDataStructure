package sortingAlgorithms.selectionSort;

public class App {
	public static void main(String[] args) {
		int[] arr = { 4, 3, 2, 1, 3 };
		SelectionSort_HandsOn selection = new SelectionSort_HandsOn(arr);
		selection.sort();
		selection.showArray();
	}
}
