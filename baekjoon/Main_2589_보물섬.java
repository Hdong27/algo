package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2589_º¸¹°¼¶ {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[H][W];
		
		for (int i = 0; i < H; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < W; j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		int max = 0;
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] == 'W') continue;
				boolean[][] visit = new boolean[H][W];
				int[][] q = new int[H*W][2];
				int front = -1;
				int rear = -1;
				
				visit[i][j] = true;
				q[++rear] = new int[] {i, j};
				
				int loop = -1;
				while(front < rear) {
					int start = front;
					int end = rear;
					
					for (int k = start; k < end; k++) {
						int[] location = q[++front];
						
						for (int l = 0; l < 4; l++) {
							int x = location[0] + dx[l];
							int y = location[1] + dy[l];
							
							if(x >= 0 && y >= 0 && x < H && y < W
									&& !visit[x][y] && map[x][y] == 'L') {
								q[++rear] = new int[] {x, y};
								visit[x][y] = true;
							}
						}
					}
					loop++;
				}
				
				max = max > loop ? max : loop;
			}
		}
		
		System.out.println(max);
	}
}
