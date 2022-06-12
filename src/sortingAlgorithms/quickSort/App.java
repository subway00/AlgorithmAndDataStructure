package sortingAlgorithms.quickSort;

public class App {
	public static void main(String[] args) {
		int[] nums = {3, 2, 1, 0};
		
		QuickSort quickSort = new QuickSort(nums);
		quickSort.sort();
		quickSort.showArray();
	}
}
