package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_퇴사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
	    int[] t = new int[N + 1];
	    int[] p = new int[N + 1];
	    int[] dp = new int[N + 1];
	 
	 
	    for (int i = 1; i <= N; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine(), " ");
	        t[i] = Integer.parseInt(st.nextToken());
	        p[i] = Integer.parseInt(st.nextToken());
	 
	        dp[i] = p[i];
	    }
	 
	    for (int i = 2; i <= N; i++) {
	        for (int j = 1; j < i; j++) {
	            if (i >= t[j] + j) {	// 도달할 수 있는 지점
	            	dp[i] = p[i] + dp[j] > dp[i] ? p[i] + dp[j] : dp[i];
	            }
	        }
	    }
	 
	    int result = 0;
	 
	    for (int i = 1; i <= N; i++) {
	        if (i + t[i] <= N + 1) {	// 유효 범위 안에 들어오면
	        	result = result < dp[i] ? dp[i] : result;
	        }
	    }
	    
	    System.out.println(result);
	}
}
