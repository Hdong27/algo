package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16926_배열돌리기1 {
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int limit = Math.min(N, M) / 2;
		
		for (int i = 0; i < R; i++) {	// R번 회전을 한다.
			for (int s = 0; s < limit; s++) {
				move_top(s, s, M-1-s);
				move_right(M-1-s, s, N-1-s);
				move_bottom(N-1-s, M-1-s, s);
				move_left(s, N-1-s, s);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	static int temp;
	static void move_top(int index, int start, int end) {
		temp = map[index][start];
		for (int i = start; i < end; i++) {
			map[index][i] = map[index][i+1];
		}
	}
	
	static void move_right(int index, int start, int end) {
		for (int i = start; i < end; i++) {
			map[i][index] = map[i+1][index];
		}
	}
	
	static void move_bottom(int index, int start, int end) {
		for (int i = start; i > end; i--) {
			map[index][i] = map[index][i-1];
		}
	}
	
	static void move_left(int index, int start, int end) {
		for (int i = start; i > end; i--) {
			map[i][index] = map[i-1][index];
		}
		map[end + 1][index] = temp;
	}
}
