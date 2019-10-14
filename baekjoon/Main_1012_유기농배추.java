package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1012_¿Ø±‚≥ÛπË√ﬂ {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				map[x][y] = -1;
			}
			
			int[][] q = new int[N*M][2];
			int front = -1;
			int rear = -1;
			int num = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == -1) {
						map[i][j] = 1;
						q[++rear] = new int[] {i, j};
						
						while(front < rear) {
							int[] location = q[++front];
							
							for (int l = 0; l < 4; l++) {
								int x = location[0] + dx[l];
								int y = location[1] + dy[l];
								
								if(x >= 0 && y >= 0 && x < N && y < M && map[x][y] == -1) {
									map[x][y] = 1;
									q[++rear] = new int[] {x, y};
								}
							}
						}
						
						num++;
					}
				}
			}
			
			System.out.println(num);
		}
	}
}
