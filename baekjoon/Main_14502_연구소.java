package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_14502_¿¬±¸¼Ò {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		int[][] map2 = new int[N][M];
		List<Integer[]> wall = new ArrayList<>();
		List<Integer[]> list = new ArrayList<>();
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
				if(map[i][j] == 0) {
					wall.add(new Integer[] {i, j});
				} else if(map[i][j] == 2) {
					list.add(new Integer[] {i, j});
				}
			}
		}
		
		for (int a = 0; a < wall.size() - 2; a++) {
			for (int b = a + 1; b < wall.size() - 1; b++) {
				for (int c = b + 1; c < wall.size(); c++) {
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							map2[i][j] = map[i][j];
						}
					}
					
					map2[wall.get(a)[0]][wall.get(a)[1]] = 1;
					map2[wall.get(b)[0]][wall.get(b)[1]] = 1;
					map2[wall.get(c)[0]][wall.get(c)[1]] = 1;
					
					int[][] q = new int[N*M][2];
					int front = -1;
					int rear = -1;
					
					for (Integer[] virus : list) {
						q[++rear] = new int[] {virus[0], virus[1]};
					}
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int i = 0; i < 4; i++) {
							int x = location[0] + dx[i];
							int y = location[1] + dy[i];
							
							if(x >= 0 && y >= 0 && x < N && y < M && map2[x][y] == 0) {
								map2[x][y] = 2;
								q[++rear] = new int[] {x, y};
							}
						}
					}
					
					int count = 0;
					for (int i = 0; i < N; i++) {
						for (int j = 0; j < M; j++) {
							if(map2[i][j] == 0) {
								count++;
							}
						}
					}
					
					result = result > count ? result : count;
				}
			}
		}
		
		System.out.println(result);
	}
	
}
