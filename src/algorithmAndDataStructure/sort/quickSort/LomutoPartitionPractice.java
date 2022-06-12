package algorithmAndDataStructure.sort.quickSort;

public class LomutoPartitionPractice {
	public static void main(String[] args) {
		int[] arrs = {17, 20, 2, 1, 3, 21, 8};
		
		int piviot = arrs.length -1;
		partition(arrs, 0, piviot);
	}
	
	private static void partition(int[] arrs, int nowMin, int nowMax) {
		
		if (nowMin < nowMax) {
			int prePiviot = sort(arrs, nowMin, nowMax);
			//left sub arr
			partition(arrs, nowMin, prePiviot-1);
			//right sub arr
			partition(arrs, prePiviot+1, nowMax);
		}
		
	}
	
	private static int sort(int[] arrs, int min, int piviot) {
		int i = min;
		
		System.out.printf("min:%d piviot:%d%n", min, piviot);
		for(int j = min ; j < piviot ; j++) {
			if (arrs[j] <= arrs[piviot]) {
				//swap
				int temp = arrs[i];
				arrs[i] = arrs [j];
				arrs[j] = temp;
				i++;
			} 
		}
		printValues(arrs, i);
		
		//finish sort then change piviot and i
		int temp = arrs[i];
		arrs[i] = arrs[piviot];
		arrs[piviot] = temp;
		
		printValues(arrs, i);
		return i;
	}
	
	private static void printValues(int[] arrs, int i) {
		for (int arr : arrs) {
			System.out.printf("%d ", arr);
		}
		System.out.println();
		System.out.printf("i: (index: %d), (value: %d) %n", i, arrs[i]);
		System.out.println();
	}
}

