package sortingAlgorithms.selectionSort;

public class SelectionSort_HandsOn {
	int[] arr;
	
	public SelectionSort_HandsOn(int[] src) {
		this.arr = src;
	}
	
	public void sort() {
		int length = arr.length;
		
		for(int base=0 ; base <length ; base++) {
			
			for(int i=base+1 ; i<length ; i++) {
				if(arr[base] > arr[i]) {
					int temp = arr[base];
					arr[base] = arr[i];
					arr[i] = temp;
				}
			}
		}
	}
	
	
	public void showArray() {
		for(int i : arr) {
			System.out.print(i);
		}
		System.out.println();
	}
}
