package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2667_단지번호붙이기 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine().trim());
		
		int[][] map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < N; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		
		int num = 2;
		
		int[][] q = new int[N*N][2];
		int front = -1;
		int rear = -1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					map[i][j] = num;
					q[++rear] = new int[] {i, j};
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int k = 0; k < 4; k++) {
							int x = location[0] + dx[k];
							int y = location[1] + dy[k];
							
							if(x >= 0 && y >= 0 && x < N && y < N && map[x][y] == 1) {
								map[x][y] = num;
								q[++rear] = new int[] {x, y};
							}
						}
					}
					
					num++;
				}
			}
		}
		
		System.out.println(num - 2);
		
		int[] count = new int[num - 2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] > 1) {
					count[map[i][j] - 2]++;
				}
			}
		}
		
		Arrays.sort(count);
		
		for (int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
