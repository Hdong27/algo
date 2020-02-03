package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1954_´ÞÆØÀÌ¼ýÀÚ {
	
	static int N;
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N+2][N+2];
			
			for (int i = 0; i <= N + 1; i++) {
				map[0][i] = -1;
				map[i][0] = -1;
				map[N + 1][i] = -1;
				map[i][N + 1] = -1;
			}
			
			function(1, 1, 1, 'r');
			
			System.out.println("#" + t);
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	static void function(int x, int y, int n, char dir) {
		if(n > N * N) return;
		
		map[x][y] = n;
		
		switch(dir) {
		case 'u':
			if(map[x - 1][y] == 0) {
				function(x - 1, y, n + 1, dir);
			} else {
				function(x, y + 1, n + 1, 'r');
			}
			break;
		case 'd':
			if(map[x + 1][y] == 0) {
				function(x + 1, y, n + 1, dir);
			} else {
				function(x, y - 1, n + 1, 'l');
			}
			break;
		case 'r':
			if(map[x][y + 1] == 0) {
				function(x, y + 1, n + 1, dir);
			} else {
				function(x + 1, y, n + 1, 'd');
			}
			break;
		case 'l':
			if(map[x][y - 1] == 0) {
				function(x, y - 1, n + 1, dir);
			} else {
				function(x - 1, y, n + 1, 'u');
			}
			break;
		}
	}
}
