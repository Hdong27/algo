package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_5644_�������� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int M = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			int[][] move = new int[2][M];
			
			for (int i = 0; i < 2; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < M; j++) {
					move[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			Battery[] bts = new Battery[C];
			
			for (int i = 0; i < C; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				bts[i] = new Battery(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			Arrays.sort(bts);
			
			int result = 0;
			// A : (0,0), B : (10,10)
			int[][] user = {{1,1},{10,10}};
			
			// � �����⿡ ���� �ִ��� Ȯ���� �Ѵ�.
			// ����� �������� �Ŀ��� ���ϰ� �����̵��� �Ѵ�.
			for (int i = 0; i <= M; i++) {
				boolean[][] check = new boolean[2][C];
				
				for (int j = 0; j < C; j++) {
					// A, B�� ��� ���� �ִ��� Ȯ���� �Ѵ�.
					for (int k = 0; k < 2; k++) {
						int dir = Math.abs(user[k][0] - bts[j].x) + Math.abs(user[k][1] - bts[j].y);
						if(bts[j].range >= dir) {	// ���� �ȿ� ���� ������
							check[k][j] = true;
						}
					}
				}
				
				// �������� �Ŀ��� ���Ѵ�.
				int count = 0;
				int index = -1;
				for (int j = 0; j < C; j++) {
					if(check[0][j]) {
						result += bts[j].power;
						index = j;
						break;
					}
				}
				
loop:			for (int j = 0; j < C; j++) {
					if(check[1][j]) {
						if(index == j) {
							// A�� B�� ���ϸ鼭 true�ΰ� �ϳ��� ���ϰ� ������.
							for (int k = j + 1; k < C; k++) {
								if(check[0][k] || check[1][k]) {
									result += bts[k].power;
									break loop;
								}
							}
						} else {
							result += bts[j].power;
							break;
						}
					}
				}
				
				
//				System.out.println(i + " : " + user[0][0] + ", " + user[0][1]);
//				System.out.println(i + " : " + result);
				if(i >= M) break;
				
				// A, B�� �̵���Ų��.
				for (int j = 0; j < 2; j++) {
					switch(move[j][i]) {
					case 1:	// ��
						user[j][1]--;
						break;
					case 2:	// ��
						user[j][0]++;
						break;
					case 3:	// ��
						user[j][1]++;
						break;
					case 4:	// ��
						user[j][0]--;
						break;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	static class Battery implements Comparable<Battery>{
		int x;
		int y;
		int range;
		int power;
		
		public Battery(int x, int y, int range, int power) {
			this.x = x;
			this.y = y;
			this.range = range;
			this.power = power;
		}

		@Override
		public int compareTo(Battery o) {
			return o.power - this.power;
		}
		
		
	}
}
