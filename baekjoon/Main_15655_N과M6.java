package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_N°úM6 {
	private static int N;
	private static int M;
	static int[] save;
	static boolean[] visit;
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
		
		save = new int[M];
		visit = new boolean[N];
		Comb(0, 0);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(save[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for (int i = start; i < N; i++) {
			save[cnt] = arr[i];
			Comb(cnt+1, i+1);
		}
	}
}
