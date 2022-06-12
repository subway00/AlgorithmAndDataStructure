package sortingAlgorithms.insertionSort;

public class App {
	public static void main(String[] args) {
		int[] arr = {4,3,2,1, 3};
		
		InsertionSort sort = new InsertionSort(arr);
		sort.sort();
		sort.showArray();
	}
	
}
