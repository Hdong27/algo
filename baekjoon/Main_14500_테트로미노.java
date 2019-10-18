package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14500_테트로미노 {
	private static int N;
	private static int M;
	private static int[][] map;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				function1(i, j);
				function2(i, j);
				function3(i, j);
				function4(i, j);
				function5(i, j);
				function6(i, j);
				function7(i, j);
				function8(i, j);
				function9(i, j);
				function10(i, j);
				function11(i, j);
				function12(i, j);
				function13(i, j);
				function14(i, j);
				function15(i, j);
				function16(i, j);
				function17(i, j);
				function18(i, j);
				function19(i, j);
			}
		}
		
		System.out.println(result);
	}
	
	static void updateResult(int temp) {
		result = temp > result ? temp : result;
	}
	
	static void function1(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 4; i++) {
			if(y + i >= M) return;
			temp += map[x][y+i];
		}
		
		updateResult(temp);
	}
	
	static void function2(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 4; i++) {
			if(x + i >= N) return;
			temp += map[x+i][y];
		}
		
		updateResult(temp);
	}
	
	static void function3(int x, int y) {
		int temp = 0;
		for (int i = 0; i < 2; i++) {
			if(x + i >= N) return;
			for (int j = 0; j < 2; j++) {
				if(y + j >= M) return;
				temp += map[x+i][y+j];
			}
		}
		
		updateResult(temp);
	}
	
	static void function4(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if(x + i >= N) return;
			temp += map[x+i][y];
		}
		if(y + 1 >= M) return;
		temp += map[x+2][y+1];
		
		updateResult(temp);
	}
	
	static void function5(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if(x + i >= N) return;
			temp += map[x+i][y];
		}
		if(y - 1 < 0) return;
		temp += map[x+2][y-1];
		
		updateResult(temp);
	}
	
	static void function6(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if(y + i >= M) return;
			temp += map[x][y+i];
		}
		if(x + 1 >= N) return;
		temp += map[x+1][y];
		
		updateResult(temp);
	}
	
	static void function7(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if(y + i >= M) return;
			temp += map[x][y+i];
		}
		if(x + 1 >= N) return;
		temp += map[x+1][y+2];
		
		updateResult(temp);
	}
	
	static void function8(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		
		if(x + 1 >= N) return;
		for (int i = 0; i < 3; i++) {
			if(y + i >= M) return;
			temp += map[x+1][y+i];
		}
		
		updateResult(temp);
	}
	
	static void function9(int x, int y) {
		int temp = 0;
		
		for (int i = 0; i < 3; i++) {
			if(y + i >= M) return;
			temp += map[x][y+i];
		}
		
		if(x - 1 < 0) return;
		temp += map[x-1][y+2];
		
		updateResult(temp);
	}
	
	static void function10(int x, int y) {
		int temp = 0;
		
		if(y + 1 >= M) return;
		temp += map[x][y+1];
		
		for (int i = 0; i < 3; i++) {
			if(x + i >= N) return;
			temp += map[x+i][y];
		}
		
		updateResult(temp);
	}
	
	static void function11(int x, int y) {
		int temp = 0;

		temp += map[x][y];

		if(y + 1 >= M) return;
		for (int i = 0; i < 3; i++) {
			if(x + i >= N) return;
			temp += map[x+i][y+1];
		}
		
		updateResult(temp);
	}
	
	static void function12(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(x + 1 >= N) return;
		temp += map[x+1][y];
		if(y + 1 >= M) return;
		temp += map[x+1][y+1];
		if(x + 2 >= N) return;
		temp += map[x+2][y+1];
		
		updateResult(temp);
	}
	
	static void function13(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(x + 1 >= N) return;
		temp += map[x+1][y];
		if(y - 1 < 0) return;
		temp += map[x+1][y-1];
		if(x + 2 >= N) return;
		temp += map[x+2][y-1];
		
		updateResult(temp);
	}
	
	static void function14(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(y + 1 >= M) return;
		temp += map[x][y+1];
		if(x - 1 < 0) return;
		temp += map[x-1][y+1];
		if(y + 2 >= M) return;
		temp += map[x-1][y+2];
		
		updateResult(temp);
	}
	
	static void function15(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(y + 1 >= M) return;
		temp += map[x][y+1];
		if(x + 1 >= N) return;
		temp += map[x+1][y+1];
		if(y + 2 >= M) return;
		temp += map[x+1][y+2];
		
		updateResult(temp);
	}
	
	static void function16(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(y + 1 >= M) return;
		temp += map[x][y+1];
		if(y + 2 >= M) return;
		temp += map[x][y+2];
		if(x + 1 >= N) return;
		temp += map[x+1][y+1];
		
		updateResult(temp);
	}
	
	static void function17(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(y + 1 >= M) return;
		temp += map[x][y+1];
		if(y + 2 >= M) return;
		temp += map[x][y+2];
		if(x - 1 < 0) return;
		temp += map[x-1][y+1];
		
		updateResult(temp);
	}
	
	static void function18(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(y + 1 >= M) return;
		temp += map[x][y+1];
		if(x - 1 < 0) return;
		temp += map[x-1][y+1];
		if(x + 1 >= N) return;
		temp += map[x+1][y+1];
		
		updateResult(temp);
	}
	
	static void function19(int x, int y) {
		int temp = 0;
		
		temp += map[x][y];
		if(x + 1 >= N) return;
		temp += map[x+1][y];
		if(x + 2 >= N) return;
		temp += map[x+2][y];
		if(y + 1 >= M) return;
		temp += map[x+1][y+1];
		
		updateResult(temp);
	}
}
