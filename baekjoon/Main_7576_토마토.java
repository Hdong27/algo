package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7576_≈‰∏∂≈‰ {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		int total = N*M;
		int cur = 0;
		
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					cur++;
					q[++rear] = new int[] {i, j};
				} else if(map[i][j] == -1) {
					total--;
				}
			}
		}
		
		int loop = 0;
		while(front < rear) {
			loop++;
			int start = front;
			int end = rear;
			
			for (int i = start; i < end; i++) {
				int[] location = q[++front];
				
				for (int j = 0; j < 4; j++) {
					int x = location[0] + dx[j];
					int y = location[1] + dy[j];
					
					if(x >= 0 && y >= 0 && x < N && y < M && map[x][y] == 0) {
						map[x][y] = 1;
						cur++;
						q[++rear] = new int[] {x, y};
					}
				}
			}
		}
		
		if(cur == total) {
			System.out.println(loop - 1);
		} else {
			System.out.println(-1);
		}
	}
}
