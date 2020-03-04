package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_1220_Magnetic {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int result = 0;
			for (int i = 0; i < N; i++) {
				// 1, 2 의 갯수를 찾아라
				int[] stack = new int[N];
				int top = -1;
				for (int j = 0; j < N; j++) {
					if(map[j][i] == 1) {
						if(top == -1 || stack[top] != 1) {
							stack[++top] = 1;
						}
					} else if(map[j][i] == 2) {
						if(top > -1 && stack[top] == 1) {
							stack[++top] = 2;
						}
					}
				}
				
				result += (top + 1) / 2;
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
