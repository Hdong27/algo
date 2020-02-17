package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로찾기_dfs {
	static int N, index;
	static boolean[] check;
	static int[][] G;
	static int[][] result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		G = new int[N][N];
		result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			check = new boolean[N];
			index = i;
			dfs(i);
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static void dfs(int v) {
		for (int i = 0; i < N; i++) {
			if(!check[i] && G[v][i] == 1) {
				check[i] = true;
				result[index][i] = 1;
				dfs(i);
			}
		}
	}
}
