package swexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution_1868_파핑파핑지뢰찾기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[][] G = new char[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					G[i][j] = s.charAt(j);
				}
			}
			
			int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
			
			int[][] map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(G[i][j] == '*') {
						map[i][j] = -1;
					} else {
						boolean flag = true;
						for (int k = 0; k < 8; k++) {
							int x = i + dx[k];
							int y = j + dy[k];
							
							if(x >= 0 && x < N && y >= 0 && y < N && G[x][y] == '*') {
								flag = false;
								break;
							}
						}
						
						if(flag) {
							map[i][j] = 0;
						} else {
							map[i][j] = 1;
						}
					}
				}
			}
			
			int result = 0;
			boolean[][] check = new boolean[N][N];
			int[][] q = new int[N*N][2];
			int front = -1;
			int rear = -1;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 0 && !check[i][j]) {
						result++;
						q[++rear] = new int[] {i, j};
						check[i][j] = true;
						
						while(front < rear) {
							int[] location = q[++front];
							
							if(map[location[0]][location[1]] == 1) {
								check[location[0]][location[1]] = true;
								continue;
							}
							
							for (int k = 0; k < 8; k++) {
								int x = location[0] + dx[k];
								int y = location[1] + dy[k];
								
								if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] >= 0 && !check[x][y]) {
									q[++rear] = new int[] {x, y};
									check[x][y] = true;
								}
							}
						}
						
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1 && !check[i][j]) {
						result++;
					}
				}
			}
			
			bw.append("#" + t + " " + result + "\n");
		}
		bw.flush();
	}
}
