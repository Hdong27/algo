package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5656_�������� {
	private static int W;
	private static int H;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// ���� ����
			W = Integer.parseInt(st.nextToken());	// ������ ���� : y
			H = Integer.parseInt(st.nextToken());	// ������ ���� : x
			
			int[][] map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < W; j++) {
					map[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			result = Integer.MAX_VALUE;
			
			for (int i = 0; i < W; i++) {
				dfs(N, map, i);
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static void dfs(int N, int[][] map, int y) {
		if(N == 0) {
			// ��� ���� ����߷����� ���� ������ ������ ���Ѵ�.
			int count = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(map[i][j] != 0) {
						count++;
					}
				}
			}

			result = result < count ? result : count;
			return;
		}
		
		// ���� ����ϱ� ���� ���縦 �Ѵ�.
		int[][] temp = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				temp[i][j] = map[i][j];
			}
		}
		
		// ������ ���� �߸���.
		int x = -1;
		for (int i = 0; i < H; i++) {
			if(temp[i][y] > 0) {
				x = i;
				break;
			}
		}
		
		// ������ ������ ���� ����� �������� ������ �����ϴ� �۾��� ���� �ʴ´�.
		if(x != -1) {
			boolean[][] check = new boolean[H][W];
			
			// ����� �����Ѵ�.
			int[][] q = new int[H * W][2];
			int front = -1;
			int rear = -1;
			
			if(temp[x][y] > 1) {
				q[++rear] = new int[] {x, y};
			}
			check[x][y] = true;
			
			while(front < rear) {
				int[] location = q[++front];
				
				for (int i = 1; i < temp[location[0]][location[1]]; i++) {
					if(location[0] - i >= 0 && !check[location[0] - i][location[1]] && temp[location[0] - i][location[1]] > 0) {
						if(temp[location[0] - i][location[1]] > 1) {
							q[++rear] = new int[] {location[0] - i, location[1]};
						}
						check[location[0] - i][location[1]] = true;
					}
					
					if(location[0] + i < H && !check[location[0] + i][location[1]] && temp[location[0] + i][location[1]] > 0) {
						if(temp[location[0] + i][location[1]] > 1) {
							q[++rear] = new int[] {location[0] + i, location[1]};
						}
						check[location[0] + i][location[1]] = true;
					}
					
					if(location[1] - i >= 0 && !check[location[0]][location[1] - i] && temp[location[0]][location[1] - i] > 0) {
						if(temp[location[0]][location[1] - i] > 1) {
							q[++rear] = new int[] {location[0], location[1] - i};
						}
						check[location[0]][location[1] - i] = true;
					}
					
					if(location[1] + i < W && !check[location[0]][location[1] + i] && temp[location[0]][location[1] + i] > 0) {
						if(temp[location[0]][location[1] + i] > 1) {
							q[++rear] = new int[] {location[0], location[1] + i};
						}
						check[location[0]][location[1] + i] = true;
					}
				}
			}
			
			// ����� ����
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if(check[i][j]) {
						temp[i][j] = 0;
					}
				}
			}
			
			// q�� ��ĭ �ۿ� ���� ������ ���� �ϳ��� ���������Ƿ� ������ �ʾƵ� �ȴ�.
			if(front == rear) {
				// ��ĭ�� ���� ����� ������.
				for (int i = 0; i < W; i++) {
					int[] q2 = new int[H];
					front = H;
					rear = H;
					for (int j = H - 1; j >= 0; j--) {
						if(temp[j][i] > 0) {
							q2[--rear] = temp[j][i];
							temp[j][i] = 0;
						}
					}
					
					for (int j = front - 1; j >= rear; j--) {
						temp[j][i] = q2[j];
					}
				}
			}
			
		}
		
		for (int i = 0; i < W; i++) {
			dfs(N-1, temp, i);
		}
	}
}
