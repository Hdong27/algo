package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16927_배열돌리기2 {
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
		int[] arr = new int[limit];
		
		for (int i = 0; i < limit; i++) {
			arr[i] = 2 * (N - 2 * i) + 2 * (M - 2 * i) - 4;
		}
		
		int temp = 0;
		
		for (int s = 0; s < limit; s++) {
			int index = R % arr[s];
			for (int k = 0; k < index; k++) {	// 각 라인마다 돌리는 횟수를 다르게
				temp = map[s][s];
				for (int j = s; j < M-1-s; j++) {
					map[s][j] = map[s][j+1];
				}
				for (int j = s; j < N-1-s; j++) {
					map[j][M-1-s] = map[j+1][M-1-s];
				}
				for (int j = M-1-s; j > s; j--) {
					map[N-1-s][j] = map[N-1-s][j-1];
				}
				for (int j = N-1-s; j > s; j--) {
					map[j][s] = map[j-1][s];
				}
				map[s + 1][s] = temp;
			}
		}
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
