package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트와링크 {
	static int N;
	static int r;
	static int[] save;
	static int result;
	private static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = Integer.MAX_VALUE;
		r = N / 2;
		save = new int[r];
		
		Comb(0, 0);
		
		System.out.println(result);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == r) {
			cal();
			return;
		}
		
		for (int i = start; i < N; i++) {
			save[cnt] = i;
			Comb(cnt+1, i+1);
		}
	}
	
	static void cal() {
		int team1 = 0;	// 스타트 팀
		int team2 = 0;	// 링크 팀
		
		boolean[] check = new boolean[N];
		for (int i = 0; i < r; i++) {
			check[save[i]] = true;
		}
		
		int[] link = new int[r];
		int index = 0;
		for (int i = 0; i < N; i++) {
			if(!check[i]) link[index++] = i;
		}
		
		// save가 스타트팀, link가 링크팀
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				if(i == j) continue;
				team1 += map[save[i]][save[j]];
			}
		}
		
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < r; j++) {
				if(i == j) continue;
				team2 += map[link[i]][link[j]];
			}
		}
		
		result = result < Math.abs(team1 - team2) ? result : Math.abs(team1 - team2);
	}
}
