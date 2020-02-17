package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11403_경로찾기_bfs {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] G = new int[N][N];
		int[][] result = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			boolean[] check = new boolean[N];
			int[] q = new int[N*N];
			int front = -1;
			int rear = -1;
			
			for (int j = 0; j < N; j++) {
				if(!check[j] && G[i][j] == 1) {
					q[++rear] = j;
					check[j] = true;
					
					while(front < rear) {
						int location = q[++front];
						result[i][location] = 1;
						
						if(i == location) continue;
						
						for (int k = 0; k < N; k++) {
							if(!check[k] && G[location][k] == 1) {
								q[++rear] = k;
								check[k] = true;
							}
						}
					}
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}
}
