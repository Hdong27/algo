package programmers;

import java.util.Arrays;

public class Solution_보행자천국 {
	
	public static void main(String[] args) {
		System.out.println(solution(3, 3, new int[][] {
			{0, 0, 0},
			{0, 0, 0},
			{0, 0, 0}
		}));
		System.out.println(solution(3, 6, new int[][] {
			{0, 2, 0, 0, 0, 2},
			{0, 0, 2, 0, 1, 0},
			{1, 0, 0, 2, 2, 0}
		}));
	}
	
	public static int solution(int m, int n, int[][] cityMap) {
		int MOD = 20170805;
		
		int[][] right = new int[m + 2][n + 2];
		int[][] down = new int[m + 2][n + 2];
		right[1][1] = 1;
		down[1][1] = 1;
		
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if(i == 1 && j == 1) continue;
				int val = cityMap[i-1][j-1];
				if(val == 0) {
					right[i][j] = (right[i][j-1] + down[i-1][j]) % MOD;
					down[i][j] = (right[i][j-1] + down[i-1][j]) % MOD;
				} else if(val == 2) {
					right[i][j] = right[i][j-1];
					down[i][j] = down[i-1][j];
				} else {
					right[i][j] = 0;
					down[i][j] = 0;
				}
			}
		}
		
		return down[m][n];
	}
}
