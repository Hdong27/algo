package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1952_¼ö¿µÀå {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int[] money = new int[4];
			
			for (int i = 0; i < 4; i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine(), " ");
			int[] dp = new int[13];
			
			for (int i = 1; i <= 12; i++) {
				int day = Integer.parseInt(st.nextToken());
				dp[i] = (day * money[0] < money[1] ? day * money[0] : money[1]) + dp[i-1];
				if(i >= 3) {
					dp[i] = dp[i-3] + money[2] < dp[i] ? dp[i-3] + money[2] : dp[i];
				}
			}
			
			sb.append('#').append(t).append(' ').append(dp[12] < money[3] ? dp[12] : money[3]).append("\n");
		}
		System.out.println(sb);
	}
}
