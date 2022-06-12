package sortingAlgorithms.insertionSort;

public class InsertionSort {
	private int[] nums;
	
	public InsertionSort(int[] nums) {
		this.nums = nums;
	}
	
	public void sort() {
		
		for(int i=0; i<nums.length;++i) {
			
			int j = i;
			
			while( j > 0 && nums[j-1] > nums[j]) {
				swap(j, j-1);
				j--;
			}
		}
	}
	
	private void swap(int i, int j) {
		System.out.println(i + "-" + j);
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
	
	public void showArray() {
		for(int i=0 ; i<nums.length ; ++i) {
			System.out.print(nums[i] +" ");
		}
	}
}
