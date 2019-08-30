package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_��Ϲ��� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] roll = new int[5][8];
		
		for (int i = 1; i < 5; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < 8; j++) {
				roll[i][j] = s.charAt(j) - '0';
			}
		}
		
		int K = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int a = Integer.parseInt(st.nextToken());	// ��Ϲ��� ��ȣ
			int b = Integer.parseInt(st.nextToken());	// ���� : 1=�ð�, -1=�ݽð�
			
			int[][] check = new int[5][2];
			
			check[a][0] = 1;
			check[a][1] = b;
			
			// ������ Ȯ��
			for (int j = a; j > 1; j--) {
				if(roll[j][6] != roll[j-1][2]) {	// ���� ������ ���� ���� �ٸ���
					// ������ ������.
					check[j-1][0] = 1;
					check[j-1][1] = check[j][1] == 1 ? -1 : 1;
				} else {
					break;
				}
			}
			
			// �������� Ȯ��
			for (int j = a; j < 4; j++) {
				if(roll[j][2] != roll[j+1][6]) {	// ������ ������ ���� ���� �ٸ���
					// ������ ������.
					check[j+1][0] = 1;
					check[j+1][1] = check[j][1] == 1 ? -1 : 1;
				} else {
					break;
				}
			}
			
			for (int j = 1; j < 5; j++) {
				if(check[j][0] == 1) {
					// ������ ������ �ϸ� �ش� �������� ������.
					if(check[j][1] == 1) {
						// �ð�������� ������.
						int temp = roll[j][7];
						for (int l = 7; l > 0; l--) {
							roll[j][l] = roll[j][l-1];
						}
						roll[j][0] = temp;
					} else {	// check[j][1] == -1
						// �ݽð� �������� ������.
						int temp = roll[j][0];
						for (int l = 0; l < 7; l++) {
							roll[j][l] = roll[j][l+1];
						}
						roll[j][7] = temp;
					}
				}
			}
			
			
		}
		int result = 0;
		
		// �� ������ ���� ����Ѵ�.
		for (int j = 1; j <= 4; j++) {
			if(roll[j][0] == 1) {
				result += 1 << (j - 1);
			}
		}
		
		System.out.println(result);
	}
}
