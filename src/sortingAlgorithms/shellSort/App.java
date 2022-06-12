package sortingAlgorithms.shellSort;

public class App {
	public static void main(String[] args) {
		int [] nums = {2, 5, -1, 0, 1, 2, 3};
		
		ShellSort sort = new ShellSort(nums);
		sort.sort();
		sort.showArray();
	}
}
