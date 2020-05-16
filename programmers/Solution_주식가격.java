package programmers;

import java.util.Arrays;

public class Solution_주식가격 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {5, 4, 3, 2, 1, 2, 3, 4, 5})));
	}
	
	public static int[] solution(int[] prices) {
		int[] stack = new int[prices.length];
		int top = -1;
		
		int[] answer = new int[prices.length];
		
		for (int i = 0; i < answer.length; i++) {
			if(top == -1) {
				stack[++top] = i;
			} else {
				while(top >= 0 && prices[stack[top]] > prices[i]) {
					answer[stack[top]] = i - stack[top];
					top--;
				}
				stack[++top] = i;
			}
		}
		
		for (int i = 0; i <= top; i++) {
			answer[stack[i]] = prices.length - 1 - stack[i];
		}
		
		return answer;
	}
}
