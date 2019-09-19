package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2156_포도주시식 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[] p = new int[N+1];
		int[] dp = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			p[i] = Integer.parseInt(br.readLine().trim());
		}
		
		dp[1] = p[1];
		if(N > 1) {
			dp[2] = p[1] + p[2];
			
			for (int i = 3; i <= N; i++) {
				int max = dp[i-2] + p[i] > dp[i-3] + p[i-1] + p[i] ? dp[i-2] + p[i] : dp[i-3] + p[i-1] + p[i];
				dp[i] = dp[i-1] > max ? dp[i-1] : max;
			}
		}
		
		System.out.println(dp[N]);
	}
}
