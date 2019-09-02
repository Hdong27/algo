package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4008_숫자만들기 {
	private static int N;
	private static int min;
	private static int max;
	private static int[] num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			int sum = Integer.parseInt(st.nextToken());
			int mns = Integer.parseInt(st.nextToken());
			int mul = Integer.parseInt(st.nextToken());
			int div = Integer.parseInt(st.nextToken());
			
			num = new int[N];
			String s = br.readLine().trim();
			for (int i = 0; i < N; i++) {
				num[i] = s.charAt(i * 2) - '0';
			}
			
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			
			dfs(sum, mns, mul, div, num[0], 1);
			
			System.out.println("#" + t + " " + (max - min));
		}
		
	}
	
	static void dfs(int sum, int mns, int mul, int div, int count, int index) {
		if(index == N) {
			min = count < min ? count : min;
			max = count > max ? count : max;
			return;
		}
		
		if(sum > 0)
			dfs(sum - 1, mns, mul, div, count + num[index], index + 1);
		if(mns > 0)
			dfs(sum, mns - 1, mul, div, count - num[index], index + 1);
		if(mul > 0)
			dfs(sum, mns, mul - 1, div, count * num[index], index + 1);
		if(div > 0)
			dfs(sum, mns, mul, div - 1, count / num[index], index + 1);
		
	}
}
