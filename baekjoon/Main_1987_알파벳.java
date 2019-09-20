package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1987_¾ËÆÄºª {
	private static int[][] map;
	private static int C;
	private static int R;
	private static boolean[] check;
	private static boolean[][] visit;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visit = new boolean[R][C];
		check = new boolean[26];
		
		for (int i = 0; i < R; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < C; j++) {
				map[i][j] = s.charAt(j) - 'A';
			}
		}
		
		result = 0;
		visit[0][0] = true;
		check[map[0][0]] = true;
		dfs(0, 0, 1);
		
		System.out.println(result);
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y, int count) {
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
				if(!visit[nx][ny] && !check[map[nx][ny]]) {
					visit[nx][ny] = true;
					check[map[nx][ny]] = true;
					dfs(nx, ny, count + 1);
					visit[nx][ny] = false;
					check[map[nx][ny]] = false;
				} else {
					result = result > count ? result : count;
				}
			}
		}
	}
}
