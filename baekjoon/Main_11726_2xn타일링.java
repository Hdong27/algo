package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_11726_2xnÅ¸ÀÏ¸µ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		if(n > 2) {
			int[] dp = new int[n+1];
			dp[1] = 1;
			dp[2] = 2;
			for (int i = 3; i <= n; i++) {
				dp[i] = (dp[i-1] + dp[i-2]) % 10007;
			}
			System.out.println(dp[n]);
		} else {
			System.out.println(n);
		}
	}
}
