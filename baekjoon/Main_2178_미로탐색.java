package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2178_¹Ì·ÎÅ½»ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		boolean[][] check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		
		q[++rear] = new int[] {0, 0};
		check[0][0] = true;
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int loop = 1;
		
o:		while(front < rear) {
			loop++;
			int start = front;
			int end = rear;
			
			for (int i = start; i < end; i++) {
				int[] location = q[++front];
				
				for (int j = 0; j < 4; j++) {
					int x = location[0] + dx[j];
					int y = location[1] + dy[j];
					
					if(x == N - 1 && y == M - 1) {
						break o;
					}
					
					if(x >= 0 && y >= 0 && x < N && y < M && !check[x][y] && map[x][y] == 1) {
						q[++rear] = new int[] {x, y};
						check[x][y] = true;
					}
				}
			}
		}
		
		System.out.println(loop);
	}
}
