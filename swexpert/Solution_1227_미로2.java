package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1227_미로2 {
	static boolean flag;
	static int[][] map;
	static boolean[][] check;
	static int[] start, end;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			map = new int[100][100];
			check = new boolean[100][100];
			
			start = new int[2];
			end = new int[2];
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j) - '0';
					if(map[i][j] == 2) {
						start = new int[] {i, j};
					} else if(map[i][j] == 3) {
						end = new int[] {i, j};
					}
				}
			}
			
			flag = false;
			
			// start부터 시작해서 dfs를 돌면서 end에 도착하는지 확인
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
		if(x == end[0] && y == end[1]) {
			flag = true;
			return;
		}
		
		if(flag) return;
		
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(!check[nx][ny] && (map[nx][ny] == 0 || map[nx][ny] == 3)) {
				check[nx][ny] = true;
				dfs(nx, ny);
			}
		}
	}
}
