package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15664_N°úM10 {
	private static int N;
	private static int M;
	private static int[] arr;
	private static int[] save;
	static Set<String> hs;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		hs = new HashSet<>();
		
		arr = new int[N];
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		save = new int[M];
		Comb(0, 0);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == M) {
			String result = "";
			for (int i = 0; i < M; i++) {
				result += save[i] + " ";
			}
			if(hs.add(result)) {
				System.out.println(result);
			}
			return;
		}
		
		for (int i = start; i < N; i++) {
			save[cnt] = arr[i];
			Comb(cnt+1, i+1);
		}
	}
}
