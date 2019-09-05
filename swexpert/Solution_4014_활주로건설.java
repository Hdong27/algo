package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_Ȱ�ַΰǼ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// ���� ũ��
			int X = Integer.parseInt(st.nextToken());	// ������ ����
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			// ��� �濡 ���� Ž���ϸ鼭 ���η� ���� �ִ� ���� � ���� ����
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				int prev = map[i][0];
				int count = 1;
loop1:			for (int j = 1; j < N; j++) {
					if(map[i][j] == prev) {
						// ���� ���ڸ� ������ count�� ����
						count++;
					} else if(map[i][j] == prev + 1) {
						// count�� Ȯ���ؼ� ��縦 ����� ������ ���� �ƴϸ� ������.
						if(count >= X) {
							prev = map[i][j];
							count = 1;
						} else {
							flag = false;
							break;
						}
					} else if(map[i][j] == prev - 1) {	// map[i][j] < prev
						// ���� ��ϵ鿡 ��縦 ���� �� �ִ��� Ȯ�����Ѵ�.
						for (int k = j + 1; k < j + X; k++) {
							if(k >= N || map[i][k] != map[i][j]) {
								flag = false;
								break loop1;
							}
						}
						j += X - 1;
						prev = map[i][j];
						count = 0;
					} else {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					result++;
				}
				
				flag = true;
				prev = map[0][i];
				count = 1;
loop2:			for (int j = 1; j < N; j++) {
					if(map[j][i] == prev) {
						// ���� ���ڸ� ������ count�� ����
						count++;
					} else if(map[j][i] == prev + 1) {
						// count�� Ȯ���ؼ� ��縦 ����� ������ ���� �ƴϸ� ������.
						if(count >= X) {
							prev = map[j][i];
							count = 1;
						} else {
							flag = false;
							break;
						}
					} else if(map[j][i] == prev - 1) {	// map[j][i] < prev
						// ���� ��ϵ鿡 ��縦 ���� �� �ִ��� Ȯ�����Ѵ�.
						for (int k = j + 1; k < j + X; k++) {
							if(k >= N || map[k][i] != map[j][i]) {
								flag = false;
								break loop2;
							}
						}
						j += X - 1;
						prev = map[j][i];
						count = 0;
					} else {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					result++;
				}
				
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
