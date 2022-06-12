package sortingAlgorithms.mergeSort;

public class MergeSort {
	private int[] nums;
	private int[] tempArray;
	
	public MergeSort(int[] nums) {
		this.nums = nums;
		this.tempArray = new int[nums.length];
	}
	
	public void sort() {
		mergeSort(0, nums.length - 1);
	}
	
	//DIVIDE AND CONQUER APPROACH
	private void mergeSort(int low, int high) {
		//base-case
		if(low >= high) {
			return;
		}
		
		//middle item
		int middleItem = (low + high) / 2;
		
		//we keeping splitting the problem into smaller and smaller sub-problems
		//until a given array just contains just 1 item
		mergeSort(low, middleItem);
		mergeSort(middleItem + 1, high);
		
		//we have to combine the sub-solutions
		merge(low, middleItem, high);
	}
	
	private void merge(int low, int middle, int high) {
		//copy the items into the temporary array
		for(int i=low ; i<=high ; ++i) {
			tempArray[i] = nums[i];
		}
		
		int i = low;
		int j = middle + 1;
		int k = low;
		
		//we consider the temp array and copy the items into the nums
		while(i <= middle && j<=high) {
			if(tempArray[i] < tempArray[i]) {
				nums[k] = tempArray[i];
				++i;
			} else {
				nums[k] = tempArray[j];
				++j;
			}
			++k;
		}
		
		//we have to copy the items from the left sub-array (if there are any)
		while(i <= middle) {
			nums[k] = tempArray[i];
			++k;
			++i;
		}
		//we have to copy the items from the right sub-array (if there are any)
		while(j <= high) {
			nums[k] = tempArray[j];
			++k;
			++j;
		}
	}
	
	private void showArray() {
		for(int i=0; i<nums.length ; ++i) {
			
		}
	}
	
	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
