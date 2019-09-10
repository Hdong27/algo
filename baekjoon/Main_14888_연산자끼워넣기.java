package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14888_연산자끼워넣기 {
	private static int[] num;
	private static int N;
	private static int max;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		num = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		int sum = Integer.parseInt(st.nextToken());
		int minus = Integer.parseInt(st.nextToken());
		int mul = Integer.parseInt(st.nextToken());
		int div = Integer.parseInt(st.nextToken());
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		
		dfs(sum, minus, mul, div, 1, num[0]);
		
		System.out.println(max);
		System.out.println(min);
		
	}
	
	static void dfs(int sum, int minus, int mul, int div, int index, int value) {
		if(index == N){
			max = Math.max(value, max);
			min = Math.min(value, min);
		}
		
		if(sum > 0)
			dfs(sum-1, minus, mul, div, index+1, value + num[index]);
		if(minus > 0)
			dfs(sum, minus-1, mul, div, index+1, value - num[index]);
		if(mul > 0)
			dfs(sum, minus, mul-1, div, index+1, value * num[index]);
		if(div > 0)
			dfs(sum, minus, mul, div-1, index+1, value / num[index]);
		
	}
}
