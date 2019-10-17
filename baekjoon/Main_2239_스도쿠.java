package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2239_스도쿠 {
	private static int[][] map;
	private static boolean[][] check;
	static boolean flag;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new int[9][9];
		check = new boolean[9][10];
		
		for (int i = 0; i < 9; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < 9; j++) {
				map[i][j] = s.charAt(j) - '0';
				check[i][map[i][j]] = true;
			}
		}
		
		flag = false;
		
		dfs(0, 0);
		
	}
	
	static void dfs(int x, int y) {
		if(x == 9) {
			flag = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			return;
		}
		
		if(flag) {
			return;
		}

		if(map[x][y] == 0) {
			for (int i = 1; i <= 9; i++) {
				if(!check[x][i]) {
					if(isAvailable(x, y, i)) {
						map[x][y] = i;
						check[x][i] = true;
					} else {
						continue;
					}
					if(y == 8) {
						dfs(x + 1, 0);
					} else {
						dfs(x, y + 1);
					}
					map[x][y] = 0;
					check[x][i] = false;
				}
			}
		} else {
			if(y == 8) {
				dfs(x + 1, 0);
			} else {
				dfs(x, y + 1);
			}
		}
	}
	
	// 해당 칸에 가능한 경우
	static boolean isAvailable(int x, int y, int val) {
		// 행
		for (int i = 0; i < 9; i++) {
			if(y == i) continue;
			if(val == map[x][i]) return false;
		}
		
		// 열
		for (int i = 0; i < 9; i++) {
			if(x == i) continue;
			if(val == map[i][y]) return false;
		}
		
		// 3x3
		if (x < 3) {
			if (y < 3) {
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			} else if (y < 6) {
				for (int i = 0; i < 3; i++) {
					for (int j = 3; j < 6; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			} else {
				for (int i = 0; i < 3; i++) {
					for (int j = 6; j < 9; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			}
		} else if (x < 6) {
			if (y < 3) {
				for (int i = 3; i < 6; i++) {
					for (int j = 0; j < 3; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			} else if (y < 6) {
				for (int i = 3; i < 6; i++) {
					for (int j = 3; j < 6; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			} else {
				for (int i = 3; i < 6; i++) {
					for (int j = 6; j < 9; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			}
		} else {
			if (y < 3) {
				for (int i = 6; i < 9; i++) {
					for (int j = 0; j < 3; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			} else if (y < 6) {
				for (int i = 6; i < 9; i++) {
					for (int j = 3; j < 6; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			} else {
				for (int i = 6; i < 9; i++) {
					for (int j = 6; j < 9; j++) {
						if(x == i && y == j) continue;
						if(val == map[i][j]) return false;
					}
				}
			}
		}
		
		return true;
	}
}
