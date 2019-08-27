package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2193_ÀÌÄ£¼ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());

		if(N > 2) {
			long[][] dp = new long[N+1][2];
			dp[1][1] = 1;
			dp[2][0] = 1;
			
			for (int i = 3; i <= N; i++) {
				dp[i][0] = dp[i-1][1] + dp[i-1][0];
				dp[i][1] = dp[i-1][0];
			}
			
			long result = dp[N][0] + dp[N][1];
			
			System.out.println(result);
		} else {
			System.out.println(1);
		}
	}
}
