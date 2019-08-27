package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2636_ġ�� {
	private static int[][] map;
	private static int N;
	private static int M;
	static int last;
	private static int cheeze;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		last = 0;
		cheeze = 0;
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
				if(map[i][j] == 1) cheeze++;
			}
		}
		
		// (0, 0) ���� bfs�� ���� �ڸ��� ���� 2�� �޲۴�. 
		makeMinus();
		
		int result = 0;
		
		while(cheeze > 0) {
			result++;
			isChange();
			makeMinus2();
		}
		
		System.out.println(result);
		System.out.println(last);
	}
	
	// ����κ��� -1�� �����.
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static void makeMinus() {
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		
		map[0][0] = -1;
		q[++rear] = new int[] {0, 0};
		
		while(front < rear) {
			int start = front;
			int end = rear;
			
			for (int i = start; i < end; i++) {
				int[] location = q[++front];
				
				for (int j = 0; j < 4; j++) {
					int x = location[0] + dx[j];
					int y = location[1] + dy[j];
					
					if(x >= 0 && y >= 0 && x < N && y < M) {	// �ε����� ����� ������
						if(map[x][y] == 0) {	// �湮���� �ʾҰ� 0�̸�
							map[x][y] = -1;
							q[++rear] = new int[] {x, y};
						}
						
					}
				}
			}
		}
	}
	
	// �ٲ� �� �ִ� ĭ�� ���� Ȯ���Ѵ�.
	static void isChange() {
		boolean[][] change = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					boolean flag = false;
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						
						if(map[x][y] == -1) {
							flag = true;
							break;
						}
					}
					
					if(flag) {
						change[i][j] = true;	// ���Ŀ� �ٲ��� �ϴ� �κ��� ���� true ó���� �Ѵ�.
					}
				}
			}
		}
		
		melt(change);
	}
	
	// ġ� ���δ�.
	static void melt(boolean[][] change) {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(change[i][j]) {
					map[i][j] = -1;
					count++;
				}
			}
		}
		last = count;
		cheeze -= last;
	}
	
	// 0�� Ȯ���ϰ� �ֺ��� ���Ⱑ ������ bfs�� �ֺ��� 0�� ��� -1�� �ٲ۴�.
	static void makeMinus2() {
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) {
					boolean flag = false;
					for (int k = 0; k < 4; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						
						if(map[x][y] == -1) {
							flag = true;
							break;
						}
					}
					
					if(flag) {
						map[i][j] = -1;
						q[++rear] = new int[] {i, j};
						
						while(front < rear) {
							int start = front;
							int end = rear;
							
							for (int k = start; k < end; k++) {
								int[] location = q[++front];
								
								for (int l = 0; l < 4; l++) {
									int x = location[0] + dx[l];
									int y = location[1] + dy[l];
									
									if(map[x][y] == 0) {
										map[x][y] = -1;
										q[++rear] = new int[] {x, y};
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
