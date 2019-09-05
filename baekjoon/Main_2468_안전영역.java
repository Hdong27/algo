package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2468_안전영역 {
	private static boolean[][] check;
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		int max = 0;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] > max) max = map[i][j];
			}
		}
		
		int result = 1;
		
		for (int rain = 1; rain < max; rain++) {
			// 해당 높이 만큼의 비가 올때 구간이 얼마나 나오는지를 계산한다.
			check = new boolean[N][N];
			int part = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] > rain && !check[i][j]) {
						dfs(i, j, rain);
						part++;
					}
				}
			}
			
			result = result > part ? result : part;
		}
		
		System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y, int rain) {
		check[x][y] = true;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N
					&& !check[nx][ny] && map[nx][ny] > rain) {
				dfs(nx, ny, rain);
			}
		}
	}
}
