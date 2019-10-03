package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_15663_N°úM9 {
	private static int N;
	private static int M;
	static int[] arr;
	static Set<String> hs;
	static boolean[] visit;
	static int[] save;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		hs = new HashSet<>();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visit = new boolean[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		save = new int[M];
		
		Perm(0);
	}
	
	static void Perm(int cnt) {
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
		
		for (int i = 0; i < N; i++) {
			if(!visit[i]) {
				visit[i] = true;
				save[cnt] = arr[i];
				Perm(cnt + 1);
				visit[i] = false;
			}
		}
	}
}
