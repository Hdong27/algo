package programmers;

import java.util.Arrays;

public class Solution_Ã¼À°º¹ {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {1, 3}, new int[] {2, 4}));
		System.out.println(solution(5, new int[] {3, 5}, new int[] {2, 4}));
	}
	
	public static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] arr = new int[n+2];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = 1;
		}
		
		for (int i = 0; i < lost.length; i++) {
			arr[lost[i]]--;
		}
		
		for (int i = 0; i < reserve.length; i++) {
			arr[reserve[i]]++;
		}
		
		for (int i = 1; i <= n; i++) {
			if(i > 1 && arr[i] == 2 && arr[i-1] == 0) {
				arr[i]--;
				arr[i-1]++;
			}
			if(i < n && arr[i] == 2 && arr[i+1] == 0) {
				arr[i]--;
				arr[i+1]++;
			}
		}
		
		for (int i = 1; i <= n; i++) {
			if(arr[i] > 0) answer++;
		}
		
		return answer;
	}
}
