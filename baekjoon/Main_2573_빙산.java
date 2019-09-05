package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2573_빙산 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	private static int N;
	private static int M;
	private static int[][] map;
	private static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		int remain = 0;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > 0) remain++;
			}
		}
		
		int day = 0;
		while(remain > 0 && isOne()) {
			day++;
			int[][] melt = new int[N][M];
			
			// 빙하를 녹이자
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] > 0) {
						// 상하좌우를 확인해서 더하자
						for (int k = 0; k < 4; k++) {
							if(map[i+dx[k]][j+dy[k]] == 0) {
								melt[i][j]++;
							}
						}
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(melt[i][j] > 0) {
						if(map[i][j] <= melt[i][j]) {
							remain--;
							map[i][j] = 0;
						} else {
							map[i][j] -= melt[i][j];
						}
					}
				}
			}
		}
		
		System.out.println(remain == 0 ? 0 : day);
	}
	
	static boolean isOne() {
		// 이게 두덩이인지 찾는다.
		int part = 0;
		check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0 && !check[i][j]) {
					dfs(i, j);
					part++;
				}
			}
		}
		
		if(part > 1) {
			return false;
		}
		return true;
	}
	
	static void dfs(int x, int y) {
		check[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(map[nx][ny] > 0 && !check[nx][ny]) {
				dfs(nx, ny);
			}
		}
	}
}
