package sortingAlgorithms.bubbleSort;

public class BubbleSort {

    private int[] nums;

    public BubbleSort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {

        //iterate to the max index minus 1
        for(int i=0 ; i<nums.length - 1 ; i++) {
            for(int j=0 ; j<nums.length -i-1 ; j++) {
                if(nums[j+1] < nums[j]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        showSortedArray();
    }

    private void showSortedArray() {
        for(int i=0 ; i<nums.length ; i++) {
            System.out.print(nums[i] + "\t");
        }
    }



}
