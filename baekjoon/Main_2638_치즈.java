package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2638_치즈 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int cheeze = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
				if(map[i][j] == 1) cheeze++;
			}
		}
		
		// 최초에 가장자리 치즈를 다 -1로 만든다.
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		
		map[0][0] = -1;
		q[++rear] = new int[] {0, 0};
		
		while(front < rear) {
			int start = front;
			int end = rear;
			
			for (int i = start; i < end; i++) {
				int[] location = q[++front];
				
				for (int j = 0; j < 4; j++) {
					int x = location[0] + dx[j];
					int y = location[1] + dy[j];
					
					if(x >= 0 && y >= 0 && x < N && y < M) {	// 배열의 범위를 벗어나지 않고
						if(map[x][y] == 0) {
							map[x][y] = -1;
							q[++rear] = new int[] {x, y};
						}
					}
				}
			}
		}
		
		int result = 0;
		
		// 치즈가 다 녹아 없어질때까지 반복한다.
		while(cheeze > 0) {
			result++;
			
			// 치즈가 녹을수 있는 구간을 구해서 체크해 놓는다.
			boolean[][] change = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 1) {
						int count = 0;
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							
							if(map[x][y] == -1) count++;
						}
						
						if(count > 1) {
							change[i][j] = true;
						}
					}
				}
			}
			
			// 치즈를 녹이고 녹은 치즈의 갯수를 구해서 전체에서 뺀다
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(change[i][j]) {
						map[i][j] = -1;
						count++;
					}
				}
			}
			
			cheeze -= count;
			
			// 치즈가 녹은 이후 공기에 노출되는 공간을 -1로 바꿔준다.
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] == 0) {
						boolean flag = false;
						for (int k = 0; k < 4; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							
							if(map[x][y] == -1) {
								flag = true;
								break;
							}
						}
						
						// 공기에 노출된 공간이 있으면 bfs로 나머지 구간을 -1로 만든다.
						if(flag) {
							map[i][j] = -1;
							q[++rear] = new int[] {i, j};
							
							while(front < rear) {
								int start = front;
								int end = rear;
								
								for (int k = start; k < end; k++) {
									int[] location = q[++front];
									
									for (int l = 0; l < 4; l++) {
										int x = location[0] + dx[l];
										int y = location[1] + dy[l];
										
										if(map[x][y] == 0) {
											map[x][y] = -1;
											q[++rear] = new int[] {x, y};
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(result);
	}
}
