package programmers;

import java.util.Arrays;

public class Solution_ž {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {6,9,5,7,4})));
		System.out.println(Arrays.toString(solution(new int[] {3,9,9,3,5,7,2})));
		System.out.println(Arrays.toString(solution(new int[] {1,5,3,6,7,6,5})));
	}
	
	public static int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		
		int[] stack = new int[heights.length];
		int top = -1;
		stack[++top] = 0;
		
		for (int i = 1; i < heights.length; i++) {
 			if(heights[stack[top]] > heights[i]) {
				answer[i] = stack[top] + 1;
				stack[++top] = i;
			} else {
				top--;
				if(top < 0) {
					stack[++top] = i;
				} else {
					i--;
				}
			}
		}
		
		return answer;
	}
}
