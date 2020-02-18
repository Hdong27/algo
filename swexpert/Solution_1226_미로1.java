package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1226_미로1 {
	static boolean flag;
	static int[][] map;
	static int[] finish;
	static boolean[][] check;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			flag = false;
			map = new int[16][16];
			check = new boolean[16][16];
			int[] start = new int[2];
			finish = new int[2];
			
			for (int i = 0; i < 16; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 16; j++) {
					map[i][j] = s.charAt(j) -'0';
					if(map[i][j] == 2) {
						start = new int[] {i, j};
					} else if(map[i][j] == 3) {
						finish = new int[] {i, j};
					}
				}
			}
			
			check[start[0]][start[1]] = true;
			dfs(start[0], start[1]);
			
			if(flag) {
				System.out.println("#" + testCase + " 1");
			} else {
				System.out.println("#" + testCase + " 0");
			}
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void dfs(int x, int y) {
		if(x == finish[0] && y == finish[1]) {
			flag = true;
			return;
		}
		
		if(flag) {
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if((map[nx][ny] == 0 || map[nx][ny] == 3) && !check[nx][ny]) {	// 갈 수 있음
				check[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
