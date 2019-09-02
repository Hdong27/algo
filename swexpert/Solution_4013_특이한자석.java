package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_Ư�����ڼ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine().trim());	// ȸ�� ��
			
			int[][] roll = new int[5][8];
			
			for (int i = 1; i <= 4; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 8; j++) {
					roll[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			for (int i = 0; i < K; i++) {	// K�� ȸ��
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				int num = Integer.parseInt(st.nextToken());	// �������� ��Ϲ����� ��ȣ
				int dir = Integer.parseInt(st.nextToken());	// �������� ����
				
				int[] check = new int[5];	// 1~4
				// num���� ���� ������ Ȯ��
				check[num] = dir;
				
				for (int j = num; j > 1; j--) {
					if(roll[j][6] != roll[j-1][2]) {
						check[j-1] = check[j] == 1 ? -1 : 1;
					} else {
						break;
					}
				}
				
				// ������
				for (int j = num; j < 4; j++) {
					if(roll[j][2] != roll[j+1][6]) {
						check[j+1] = check[j] == 1 ? -1 : 1;
					} else {
						break;
					}
				}
				
				// ���� ������.
				for (int j = 1; j < check.length; j++) {
					if(check[j] == 1) {
						// �ð�������� ������
						int temp = roll[j][7];
						for (int k = 7; k >= 1; k--) {
							roll[j][k] = roll[j][k-1];
						}
						roll[j][0] = temp;
					} else if(check[j] == -1) {
						// �ݽð�������� ������.
						int temp = roll[j][0];
						for (int k = 0; k < 7; k++) {
							roll[j][k] = roll[j][k+1];
						}
						roll[j][7] = temp;
					}
				}
			}
			
			int result = 0;
			
			for (int i = 1; i <= 4; i++) {
				if(roll[i][0] == 1) {
					result += 1 << (i -1);
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
		
	}
}
