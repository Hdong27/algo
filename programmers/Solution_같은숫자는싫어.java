package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_같은숫자는싫어 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 1, 3, 3, 0, 1, 1})));
	}
	
	public static int[] solution(int[] arr) {
		List<Integer> list = new ArrayList<>();
		int prev = arr[0];
		list.add(arr[0]);
		
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] != prev) {
				list.add(arr[i]);
				prev = arr[i];
			}
		}
		
		int[] answer = new int[list.size()];
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
