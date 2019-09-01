package swexpert;

import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Solution_3975_½Â·üºñ±³ÇÏ±â {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String result = "";
			double a = Integer.parseInt(st.nextToken()) / (double)Integer.parseInt(st.nextToken());
			double b = Integer.parseInt(st.nextToken()) / (double)Integer.parseInt(st.nextToken());
			if(a == b)	result = "DRAW";
			else if(a > b)	result = "ALICE";
			else	result = "BOB";
			sb.append('#').append(t).append(' ').append(result).append('\n');
		}
		System.out.println(sb);
	}
}
