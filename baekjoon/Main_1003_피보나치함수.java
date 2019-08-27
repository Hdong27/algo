package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1003_피보나치함수 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		int[][] dp = new int[41][2];
		dp[0] = new int[] {1, 0};
		dp[1] = new int[] {0, 1};
		
		for (int i = 2; i <= 40; i++) {
			dp[i][0] = dp[i-1][0] + dp[i-2][0];
			dp[i][1] = dp[i-1][1] + dp[i-2][1];
		}
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			System.out.println(dp[N][0] + " " + dp[N][1]);
		}
	}
}
