package algorithmAndDataStructure.stack.lnterviewQ;

public class ReversingArray {
	public static void main(String[] args) {
		
		int[] arrs = new int[]{1, 2, 3, 4, 5};
		int arrsSize = arrs.length;
		int endIdx = arrsSize -1;
		int startIdx = 0;
		
		while (startIdx < endIdx) {
			int temp = arrs[startIdx];
			arrs[startIdx] = arrs[endIdx];
			arrs[endIdx] = temp;
			startIdx ++;
			endIdx --;
		}
		
		for (int arr : arrs) {
			System.out.print(arr);
		}
	}
}
