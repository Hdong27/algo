package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_4012_요리사 {
	private static int N;
	static boolean[] check;
	private static int[][] map;
	private static int min;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 재료를 N/2 개씩 조합을 해서 가장 차이가 적은 두 조합을 찾는다.
			min = Integer.MAX_VALUE;
			check = new boolean[N];
			comb(0);
			
			System.out.println("#" + t + " " + min);
		}
	}
	
	static void comb(int index) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			if(check[i]) count++;
		}
		if(count == N / 2) {
			cal();
		}
		for (int i = index; i < N; i++) {
			check[i] = true;
			comb(i+1);
			check[i] = false;
		}
	}
	
	static void cal() {
		int[] L = new int[N/2];
		int[] R = new int[N/2];
		int indexL = 0;
		int indexR = 0;
		
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				L[indexL++] = i;
			} else {
				R[indexR++] = i;
			}
		}
		
		int resultL = 0;
		int resultR = 0;
		
		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if(i == j) continue;
				resultL += map[L[i]][L[j]];
			}
		}

		for (int i = 0; i < N / 2; i++) {
			for (int j = 0; j < N / 2; j++) {
				if(i == j) continue;
				resultR += map[R[i]][R[j]];
			}
		}
		
		min = min < Math.abs(resultL - resultR) ? min : Math.abs(resultL - resultR);
	}
}
