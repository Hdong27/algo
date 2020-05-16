package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_나누어떨어지는숫자배열 {
	public static void main(String[] args) {
		
	}
	
	public static int[] solution(int[] arr, int divisor) {
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}
		
		if(list.size() == 0) {
			return new int[] {-1};
		}
		
		Collections.sort(list);
		
		int[] answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
