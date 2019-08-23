package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16935_�迭������3 {
	private static int[][] map;
	private static int N;
	private static int M;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < R; i++) {
			int cal = Integer.parseInt(st.nextToken());
			switch(cal) {
			case 1:
				function1();
				break;
			case 2:
				function2();
				break;
			case 3:
				function3();
				break;
			case 4:
				function4();
				break;
			case 5:
				function5();
				break;
			case 6:
				function6();
				break;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		
	}
	
	static void function1() {	// 	�迭�� ���� ������Ų��.
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < M; j++) {
				int temp = map[i][j];
				map[i][j] = map[N - 1 - i][j];
				map[N - 1 - i][j] = temp;
			}
		}
	}
	
	static void function2() {	// �迭�� �¿� ������Ų��.
		for (int i = 0; i < M / 2; i++) {
			for (int j = 0; j < N; j++) {
				int temp = map[j][i];
				map[j][i] = map[j][M - 1 - i];
				map[j][M - 1 - i] = temp;
			}
		}
	}
	
	static void function3() {	// �迭�� ���������� 90�� ȸ����Ų��.
		int[][] temp = new int[M][N];
		int r = 0;
		int c = 0;
		for (int i = N-1; i >= 0; i--) {
			c = 0;
			for (int j = 0; j < M; j++) {
				// (0, M-1) => (N-1, M-1)
				//	...
				// (0, 0) => (N-1, 0)
				temp[j][i] = map[r][c];
				c++;
			}
			r++;
		}
		
		int temp2 = N;
		N = M;
		M = temp2;
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	static void function4() {	// �迭�� �������� 90�� ȸ����Ų��.
		for (int i = 0; i < 3; i++) {
			function3();
		}
	}
	
	static void function5() {	// �迭�� 4�κ����� ���� ���������� ȸ��
		int[][] temp = new int[N][M];
		// 1�� �׷� <- 4��
		int x = N / 2;
		for (int i = 0; i < N / 2; i++) {
			int y = 0;
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = map[x][y];
				y++;
			}
			x++;
		}
		
		// 2�� �׷� <- 1��
		x = 0;
		for (int i = 0; i < N / 2; i++) {
			int y = 0;
			for (int j = M / 2; j < M; j++) {
				temp[i][j] = map[x][y];
				y++;
			}
			x++;
		}
		
		// 3�� �׷� <- 2��
		x = 0;
		for (int i = N / 2; i < N; i++) {
			int y = M / 2;
			for (int j = M / 2; j < M; j++) {
				temp[i][j] = map[x][y];
				y++;
			}
			x++;
		}
		
		// 4�� �׷� <- 3��
		x = N / 2;
		for (int i = N / 2; i < N; i++) {
			int y = M / 2;
			for (int j = 0; j < M / 2; j++) {
				temp[i][j] = map[x][y];
				y++;
			}
			x++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = temp[i][j];
			}
		}
	}
	
	static void function6() {
		for (int i = 0; i < 3; i++) {
			function5();
		}
	}
}