package programmers;

import java.util.Arrays;

public class Solution_«¡∏∞≈Õ {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 3, 2}, 2));
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1}, 0));
	}
	
	public static int solution(int[] priorities, int location) {
		int answer = 0;
		
		int[] num = new int[priorities.length];
		for (int i = 0; i < num.length; i++) {
			num[i] = priorities[i];
		}
		Arrays.sort(num);
		for (int i = 0; i < num.length / 2; i++) {
			int temp = num[i];
			num[i] = num[num.length - 1 - i];
			num[num.length - 1 - i] = temp;
		}
		
		int index = 0;
		int n = 0;
		while(priorities[location] != 0) {
			if(num[n] == priorities[index]) {
				answer++;
				priorities[index] = 0;
				n++;
			}
			
			if(index >= priorities.length - 1) {
				index = 0;
			} else {
				index++;
			}
		}
		
		return answer;
	}
}
