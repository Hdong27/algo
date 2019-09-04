package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2105_����Ʈī�� {
	private static int result;
	private static int N;
	private static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			map = new int[N][N];
			int max = 0;
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					max = map[i][j] > max ? map[i][j] : max;
				}
			}
			
			boolean[] check = new boolean[max + 1];
			
			result = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(i == 0 && j == 0) continue;
					if(i == 0 && j == N - 1) continue;
					if(i == N - 1 && j == 0) continue;
					if(i == N - 1 && j == N - 1) continue;
					dfs(i, j, check.clone(), 0, i, j);
				}
			}
			System.out.println("#" + t + " " + (result == 0 ? -1 : result));
		}
	}
	
	static void dfs(int x, int y, boolean[] check, int dir, int rx, int ry) {
		if(dir == 3) {
			if(x == rx && y == ry) {
				int count = 0;
				for (int i = 1; i < check.length; i++) {
					if(check[i]) {
						count++;
					}
				}
				
				result = result > count ? result : count;
				return;
			}
		}
		
		// �̹� ���� ����Ʈ�� ��� ���� �� �̻� �������� �ʴ´�.
		if(check[map[x][y]]) {
			return;
		}
		
		// �ش� �������� ���� ����Ʈ ���� ����
		check[map[x][y]] = true;
		
		switch(dir) {
		case 0:
			// ��� �����ϴ� ���
			if(x+1 < N && y-1 >= 0) {
				dfs(x+1, y-1, check.clone(), 0, rx, ry);
			}
			// ������ ���� ���
			if(x+1 < N && y+1 < N) {
				dfs(x+1, y+1, check.clone(), 1, rx, ry);
			}
			break;
		case 1:
			// ��� �����ϴ� ���
			if(x+1 < N && y+1 < N) {
				dfs(x+1, y+1, check.clone(), 1, rx, ry);
			}
			// ������ ���� ���
			if(x-1 >= 0 && y+1 < N) {
				dfs(x-1, y+1, check.clone(), 2, rx, ry);
			}
			break;
		case 2:
			// ��� �����ϴ� ���
			if(x-1 >= 0 && y+1 < N) {
				dfs(x-1, y+1, check.clone(), 2, rx, ry);
			}
			// ������ ���� ���
			if(x-1 >= 0 && y-1 >= 0) {
				dfs(x-1, y-1, check.clone(), 3, rx, ry);
			}
			break;
		case 3:
			// ��� �����ϴ� ��� -> �� �̻� ���� �� ����
			if(x-1 >= 0 && y-1 >= 0) {
				dfs(x-1, y-1, check.clone(), 3, rx, ry);
			}
			break;
		}
	}
}
