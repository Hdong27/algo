package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501_��� {
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
	            if (i - j >= t[j]) {	// ������ �� �ִ� ����
	                dp[i] = Math.max(p[i] + dp[j], dp[i]);
	            }
	        }
	    }
	 
	    int max = 0;
	 
	    for (int i = 1; i <= N; i++) {
	        if (i + t[i] <= N + 1) {	// ��ȿ ���� �ȿ� ������
	        	max = max < dp[i] ? dp[i] : max;
	        }
	    }
	    System.out.println(max);
	}
}
