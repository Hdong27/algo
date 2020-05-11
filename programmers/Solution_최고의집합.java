package programmers;

import java.util.Arrays;

public class Solution_최고의집합 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(2, 9)));
		System.out.println(Arrays.toString(solution(2, 1)));
		System.out.println(Arrays.toString(solution(2, 8)));
	}
	
	public static int[] solution(int n, int s) {

		if(n > s) {	// 배열의 합이 s보다 클 경우 불가능
			return new int[] {-1};
		} else if(n == s) {	// 배열이 합이 s랑 같은 경우 가능한 배열 1개
			int[] arr = new int[n];
			Arrays.fill(arr, 1);
			return arr;
		}
		
		int[] result = new int[n];
		
		int temp = s / n;
		int temp2 = s % n;
		
		for (int i = 0; i < n; i++) {
			result[i] = temp;
		}
		
		int index = n - 1;
		while(temp2 > 0) {
			result[index--]++;
			temp2--;
		}
		
		return result;
	}
}
