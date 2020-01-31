package programmers;

import java.util.Arrays;

public class Solution_K¹øÂ°¼ö {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {
			{2, 5, 3}, {4, 4, 1}, {1, 7, 3}
		})));
	}
	
	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		for (int i = 0; i < commands.length; i++) {
			int[] temp = commands[i];
			
			int[] arr = new int[temp[1] - temp[0] + 1];
			int index = 0;
			for (int j = temp[0]-1; j <= temp[1]-1; j++) {
				arr[index++] = array[j];
			}
			
			Arrays.sort(arr);
			answer[i] = arr[temp[2]-1];
		}
		
		return answer;
	}
}
