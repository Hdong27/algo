package programmers;

import java.util.Arrays;

public class Solution_Ä«Ä«¿ÀÇÁ·»ÁîÄÃ·¯¸µºÏ {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(6, 4, new int[][] {
			{1, 1, 1, 0},
			{1, 2, 2, 0},
			{1, 0, 0, 1},
			{0, 0, 0, 1},
			{0, 0, 0, 3},
			{0, 0, 0, 3}
		})));
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int num = 0;
		int maxSize = 0;
		boolean[][] visit = new boolean[m][n];
		int limit = m * n;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(!visit[i][j] && picture[i][j] > 0) {
					num++;
					int[][] q = new int[limit][2];
					int front = -1;
					int rear = -1;
					q[++rear] = new int[] {i, j};
					visit[i][j] = true;
					int count = 0;
					while(front < rear) {
						int[] location = q[++front];
						count++;
						for (int k = 0; k < 4; k++) {
							int x = location[0] + dx[k];
							int y = location[1] + dy[k];
							
							if(x >= 0 && y >= 0 && x < m && y < n 
									&& !visit[x][y] && picture[x][y] == picture[i][j]) {
								q[++rear] = new int[] {x, y};
								visit[x][y] = true;
							}
						}
					}
					maxSize = count > maxSize ? count : maxSize;
				}
			}
		}
		
		return new int[] {num, maxSize};
	}
}
