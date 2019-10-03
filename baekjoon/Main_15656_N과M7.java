package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15656_N°úM7 {
	private static int N;
	private static int M;
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			dfs(1, arr[i] + " ");
		}
		
	}
	
	static void dfs(int cnt, String result) {
		if(cnt == M) {
			System.out.println(result);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			dfs(cnt+1, result + arr[i] + " ");
		}
	}
}
