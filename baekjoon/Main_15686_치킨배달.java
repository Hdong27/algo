package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {
	private static int M;
	private static int[] save;
	private static int[][] homes;
	private static int[][] stores;
	private static int result;
	private static int indexH;
	private static int indexS;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		homes = new int[N+N][2];
		stores = new int[13][2];
		indexH = 0;
		indexS = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				char temp = s.charAt(j + j);
				if(temp == '1') {
					homes[indexH++] = new int[] {i, j};
				} else if(temp == '2') {
					stores[indexS++] = new int[] {i, j};
				}
			}
		}
		
		result = Integer.MAX_VALUE;

		save = new int[M];
		Comb(0, 0);
		
		System.out.println(result);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == M) {
			function();
			return;
		}
		
		for (int i = start; i < indexS; i++) {
			save[cnt] = i;
			Comb(cnt+1, i+1);
		}
	}
	
	static void function() {
		boolean[] check = new boolean[indexS];
		for (int i = 0; i < M; i++) {
			check[save[i]] = true;
		}
		
		int count = 0;
		for (int i = 0; i < indexH; i++) {
			int dir = Integer.MAX_VALUE;
			for (int j = 0; j < indexS; j++) {
				if(!check[j]) continue;
				int temp = Math.abs(homes[i][0] - stores[j][0]) + Math.abs(homes[i][1] - stores[j][1]);
				dir = dir < temp ? dir : temp;
			}
			count += dir;
		}
		
		result = count < result ? count : result;
	}
}
