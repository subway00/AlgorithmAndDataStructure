package algorithmAndDataStructure.stack.array;

import java.util.Arrays;

public class Anagram {
	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println("check result: "+ sol.execute("restful", "fluster"));
	}
}

class Solution {
	public boolean execute(String str1, String str2) {
		char[] str1Arr = str1.toCharArray();
		char[] str2Arr = str2.toCharArray();
		
		Arrays.sort(str1Arr);
		Arrays.sort(str2Arr);
		
		if(str1Arr.length != str2Arr.length) return false;
		
		for(int i=0 ; i<str1Arr.length ; i++) {
			if(str1Arr[i] !=str2Arr[i]) {
				return false;
			}
		}
		return true;
	}
}