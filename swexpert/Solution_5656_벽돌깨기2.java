package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기2 {
	static int[] save;
	static int[][] map;
	private static int N, W, H, result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());

			map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 구슬을 떨어트릴 위치 찾기
			result = Integer.MAX_VALUE;
			save = new int[N];
			dfs(0);
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void dfs(int cnt) {
		if(cnt == N) {
			function();
			return;
		}
		
		for (int i = 0; i < W; i++) {
			save[cnt] = i;
			dfs(cnt + 1);
		}
	}
	
	static int[][] q;
	static void function() {
		// 맵을 복사
		int[][] map2 = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		// 구슬을 떨어트린다.
		for (int i = 0; i < N; i++) {
			boolean[][] check = new boolean[H][W];
			int index = save[i];
			
			for (int j = 0; j < H; j++) {
				if(map2[j][index] > 0) {	// 구슬이 있으면
					q = new int[W*H][2];
					int front = -1;
					int rear = -1;
					
					check[j][index] = true;
					q[++rear] = new int[] {j, index};
					
					while(front < rear) {
						int[] location = q[++front];
						int limit = map2[location[0]][location[1]];
						map2[location[0]][location[1]] = 0;
						
						for (int k = 1; k < limit; k++) {
							if(location[0]-k >= 0) {
								if(!check[location[0]-k][location[1]] && map2[location[0]-k][location[1]] > 0) {
									check[location[0]-k][location[1]] = true;
									q[++rear] = new int[] {location[0]-k, location[1]};
								}
							}
							
							if(location[0]+k < H) {
								if(!check[location[0]+k][location[1]] && map2[location[0]+k][location[1]] > 0) {
									check[location[0]+k][location[1]] = true;
									q[++rear] = new int[] {location[0]+k, location[1]};
								}
							}
							
							if(location[1]-k >= 0) {
								if(!check[location[0]][location[1]-k] && map2[location[0]][location[1]-k] > 0) {
									check[location[0]][location[1]-k] = true;
									q[++rear] = new int[] {location[0], location[1]-k};
								}
							}
							
							if(location[1]+k < W) {
								if(!check[location[0]][location[1]+k] && map2[location[0]][location[1]+k] > 0) {
									check[location[0]][location[1]+k] = true;
									q[++rear] = new int[] {location[0], location[1]+k};
								}
							}
						}
					}
					
					if(i == N - 1) break;
					// 맵 아래로 당기기
					for (int k = 0; k < W; k++) {
						int bottom = H - 1;
						int top = H - 1;
						while(top >= 0) {
							// 가장 먼저 0인 부분 찾기
							if(map2[top][k] > 0) {
								top--;
							} else {
								bottom = top;
								break;
							}
						}
						
						while(top >= 0) {
							if(map2[top][k] > 0) {
								map2[bottom][k] = map2[top][k];
								map2[top][k] = 0;
								bottom--;
							}
							top--;
						}
					}
					
					break;
				}
			}
		}
		
		// 블록 갯수 세기
		int count = 0;
		for (int j = 0; j < H; j++) {
			for (int k = 0; k < W; k++) {
				if(map2[j][k] > 0) {
					count++;
				}
			}
		}
		
		result = count < result ? count : result;
	}
}
