package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2583_영역구하기 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[][] map = new boolean[N][M];
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int xs = Integer.parseInt(st.nextToken());
			int ys = Integer.parseInt(st.nextToken());
			int xe = Integer.parseInt(st.nextToken());
			int ye = Integer.parseInt(st.nextToken());
			
			for (int j = xs; j < xe; j++) {
				for (int k = ys; k < ye; k++) {
					map[j][k] = true;
				}
			}
		}
		
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		
		List<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!map[i][j]) {
					map[i][j] = true;
					q[++rear] = new int[] {i, j};
					
					int size = 1;
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int l = 0; l < 4; l++) {
							int x = location[0] + dx[l];
							int y = location[1] + dy[l];
							
							if(x >= 0 && y >= 0 && x < N && y < M && !map[x][y]) {
								size++;
								map[x][y] = true;
								q[++rear] = new int[] {x, y};
							}
						}
					}
					
					list.add(size);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(list.size());
		for (Integer size : list) {
			System.out.print(size + " ");
		}
	}
}
