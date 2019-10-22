package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7562_나이트의이동거리 {
	static int[] dx = {-2, -2, -1, 1, 2, 2, 1, -1};
	static int[] dy = {-1, 1, 2, 2, 1, -1, -2, -2};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			boolean[][] map = new boolean[N][N];
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int xs = Integer.parseInt(st.nextToken());
			int ys = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine(), " ");
			int xe = Integer.parseInt(st.nextToken());
			int ye = Integer.parseInt(st.nextToken());
			
			int[][] q = new int[N*N][2];
			int front = -1;
			int rear = -1;
			
			map[xs][ys] = true;
			q[++rear] = new int[] {xs, ys};
			
			int loop = 0;
x:			while(front < rear) {
				int start = front;
				int end = rear;
				
				for (int i = start; i < end; i++) {
					int[] location = q[++front];
					
					if(location[0] == xe && location[1] == ye) {
						break x;
					}
					
					for (int j = 0; j < 8; j++) {
						int x = location[0] + dx[j];
						int y = location[1] + dy[j];
						
						if(x >= 0 && y >= 0 && x < N && y < N && !map[x][y]) {
							map[x][y] = true;
							q[++rear] = new int[] {x, y};
						}
					}
				}
				
				loop++;
			}
			
			System.out.println(loop);
		}
	}
}
