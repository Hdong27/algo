package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17779_게리멘더링2 {
	private static int[][] map;
	private static int N;
	static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		min = Integer.MAX_VALUE;
		
//		function(2, 4, 2, 1);
		
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					if(y - d1 < 0) continue;
					for (int d2 = 1; d2 < N; d2++) {
						if(y + d2 >= N || x + d1 + d2 >= N) continue;
						function(x, y, d1, d2);
					}
				}
			}
		}
		
		System.out.println(min);
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void function(int x, int y, int d1, int d2) {
		// 5번 그리기
		int[][] parts = new int[N][N];
		
		for (int i = 0; i <= d1; i++) {
			parts[x+i][y-i] = 5;
		}
		
		for (int i = 0; i <= d2; i++) {
			parts[x+i][y+i] = 5;
		}
		
		for (int i = 0; i <= d2; i++) {
			parts[x+d1+i][y-d1+i] = 5;
		}
		
		for (int i = 0; i <= d1; i++) {
			parts[x+d2+i][y+d2-i] = 5;
		}
		
		int[][] q = new int[N*N][2];
		int front = -1;
		int rear = -1;
		
		for (int i = 0; i < d1; i++) {
			if(parts[x+i+1][y-i] == 0) {
				parts[x+i+1][y-i] = 5;
				q[++rear] = new int[] {x+i+1, y-i};
			}
		}
		
		for (int i = 0; i < d2; i++) {
			if(parts[x+i+1][y+i] == 0) {
				parts[x+i+1][y+i] = 5;
				q[++rear] = new int[] {x+i+1, y+i};
			}
		}
		
		while(front < rear) {
			int[] location = q[++front];
			
			for (int i = 0; i < 4; i++) {
				int nx = location[0] + dx[i];
				int ny = location[1] + dy[i];
				
				if(parts[nx][ny] == 0) {
					parts[nx][ny] = 5;
					q[++rear] = new int[] {nx, ny};
				}
			}
		}
		
		// 1번 만들기
		for (int r = 0; r < x + d1; r++) {
			for (int c = 0; c <= y; c++) {
				if(parts[r][c] == 0) {
					parts[r][c] = 1;
				}
			}
		}
		
		// 2번 만들기
		for (int r = 0; r <= x + d2; r++) {
			for (int c = y; c < N; c++) {
				if(parts[r][c] == 0) {
					parts[r][c] = 2;
				}
			}
		}
		
		// 3번 만들기
		for (int r = x + d1; r < N; r++) {
			for (int c = 0; c < y - d1 + d2; c++) {
				if(parts[r][c] == 0) {
					parts[r][c] = 3;
				}
			}
		}
		
		// 4번 만들기
		for (int r = x + d2; r < N; r++) {
			for (int c = y - d1 + d2; c < N; c++) {
				if(parts[r][c] == 0) {
					parts[r][c] = 4;
				}
			}
		}
		
//		for (int i = 0; i < N; i++) {
//			System.out.println(Arrays.toString(parts[i]));
//		}
		
		int[] count = new int[6];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				count[parts[i][j]] += map[i][j];
			}
		}
		
		Arrays.sort(count);
		
		int result = count[5] - count[1];
//		System.out.println(x + ", " + y + ", " + d1 + ", " + d2);
//		System.out.println(result + " : " + Arrays.toString(count));
		min = result < min ? result : min;
		
	}
}
