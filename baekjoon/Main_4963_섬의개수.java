package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4963_¼¶ÀÇ°³¼ö {
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) break;
			
			int[][] map = new int[N][M];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < M; j++) {
					map[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			int result = 0;
			int[][] q = new int[N*M][2];
			int front = -1;
			int rear = -1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						q[++rear] = new int[] {i, j};
						
						while(front < rear) {
							int[] location = q[++front];
							for (int k = 0; k < 8; k++) {
								int x = location[0] + dx[k];
								int y = location[1] + dy[k];
								
								if(x >= 0 && y >= 0 && x < N && y < M && map[x][y] == 1) {
									map[x][y] = 0;
									q[++rear] = new int[] {x, y};
								}
							}
						}
						
						result++;
					}
				}
			}
			
			System.out.println(result);
		}
	}
}
