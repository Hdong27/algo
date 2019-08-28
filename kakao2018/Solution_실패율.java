 package kakao2018;

import java.util.Arrays;

public class Solution_½ÇÆÐÀ² {
	public static void main(String[] args) {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		System.out.println(Arrays.toString(solution(N, stages)));
		
		N = 4;
		stages = new int[] {4, 4, 4, 4, 4};
		
		System.out.println(Arrays.toString(solution(N, stages)));
	}
	
	public static int[] solution(int N, int[] stages) {
		int[] count = new int[N+2];
		for (int i = 0; i < stages.length; i++) {
			count[stages[i]]++;
		}
		
		double[] rate = new double[N+1];
		for (int i = 1; i < rate.length; i++) {
			int player = 0;
			for (int j = i; j < count.length; j++) {
				player += count[j];
			}
			if(count[i] == 0) {
				rate[i] = 0;
			} else {
				rate[i] = (double)count[i] / player;
			}
		}
		
		int[] answer = new int[N];
		int n = 0;
		boolean[] check = new boolean[rate.length];
		
		for (int i = 0; i < answer.length; i++) {
			int index = 0;
			double max = -1;
			
			for (int j = 1; j < rate.length; j++) {
				if(!check[j] && max < rate[j]) {
					index = j;
					max = rate[j];
				}
			}
			
			check[index] = true;
			answer[n++] = index;
		}
		
		return answer;
	}
}
