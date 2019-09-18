package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1182_부분수열의합 {
	static int N;
	static int S;
	static int r;
	static int[] save;
	static int[] num;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		num = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		result = 0;
		
		for (r = 1; r <= N; r++) {
			save = new int[r];
			Comb(0, 0);
		}
		
		System.out.println(result);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == r) {
			int sum = 0;
			for (int i = 0; i < r; i++) {
				sum += save[i];
			}
			
			if(sum == S) result++;
			return;
		}
		
		for (int i = start; i < N; i++) {
			save[cnt] = num[i];
			Comb(cnt+1, i+1);
		}
	}
}
