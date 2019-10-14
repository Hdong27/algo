package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main_1260_DFS¿ÍBFS {
	private static int N;
	private static boolean[][] G;
	private static boolean[] check;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		G = new boolean[N+1][N+1];
		check = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			G[v1][v2] = true;
			G[v2][v1] = true;
		}
		
		check[V] = true;
		dfs(V);
		
		System.out.println();
		
		check = new boolean[N+1];
		int[] q = new int[N+1];
		int front = -1;
		int rear = -1;
		
		check[V] = true;
		q[++rear] = V;
		
		while(front < rear) {
			V = q[++front];
			System.out.print(V + " ");
			
			for (int i = 1; i <= N; i++) {
				if(!check[i] && G[V][i]) {
					check[i] = true;
					q[++rear] = i;
				}
			}
		}
	}
	
	static void dfs(int V) {
		System.out.print(V + " ");
		
		for (int i = 1; i <= N; i++) {
			if(!check[i] && G[V][i]) {
				check[i] = true;
				dfs(i);
			}
		}
	}
}
