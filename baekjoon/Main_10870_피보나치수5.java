package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10870_피보나치수5 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] dp = new int[21];
		dp[0] = 0;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		
		System.out.println(dp[N]);
	}
}
