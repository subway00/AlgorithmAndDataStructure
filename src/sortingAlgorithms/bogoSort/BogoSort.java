package sortingAlgorithms.bogoSort;

public class BogoSort {
	
	// this is not efficient on classical computer O(N!)
	private int[] nums;
	private int counter;
	
	public BogoSort(int[] nums) {
		this.nums = nums;
	}
	
	public void sort() {
		while(! isSorted()) {
			counter++;
			shuffle();
		}
		
		showSortedArray();
	}
	
	private void showSortedArray() {
		
		System.out.println("The number of iterations: " + counter);
		
		for(int i=0 ; i<nums.length ; ++i) {
			System.out.println(nums[i] + " ");
		}
		
	}

	// Fisher-Yates algorithm to generate a random permutation in O(N)
	// the algorithm produces an unbiased permutation : every permutation is equally likey
	// in-place algorithm
	private void shuffle() {
		// consider the item in reverse order
		for(int i=nums.length-1 ; i>=0;--i) {
			int j = (int) (Math.random() * i);
			swap(i, j);
		}
	}
	
	// swap 2 items in the nums array in O(1)
	private void swap(int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private boolean isSorted() {
		
		//if the next item i+1 is smaller than the previous one
		//the array cannot be sorted in ascending order 1 2 3 4 5
		for(int i=0; i<nums.length-1 ; ++i) {
			if(nums[i+1] < nums[i])
			return false;
		}
		return true;
	}
}
