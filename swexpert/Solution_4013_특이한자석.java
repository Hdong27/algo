package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine().trim());	// 회전 수
			
			int[][] roll = new int[5][8];
			
			for (int i = 1; i <= 4; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 8; j++) {
					roll[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			for (int i = 0; i < K; i++) {	// K번 회전
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				
				int num = Integer.parseInt(st.nextToken());	// 돌리려는 톱니바퀴의 번호
				int dir = Integer.parseInt(st.nextToken());	// 돌리려는 방향
				
				int[] check = new int[5];	// 1~4
				// num부터 왼쪽 돌릴거 확인
				check[num] = dir;
				
				for (int j = num; j > 1; j--) {
					if(roll[j][6] != roll[j-1][2]) {
						check[j-1] = check[j] == 1 ? -1 : 1;
					} else {
						break;
					}
				}
				
				// 오른쪽
				for (int j = num; j < 4; j++) {
					if(roll[j][2] != roll[j+1][6]) {
						check[j+1] = check[j] == 1 ? -1 : 1;
					} else {
						break;
					}
				}
				
				// 이제 돌린다.
				for (int j = 1; j < check.length; j++) {
					if(check[j] == 1) {
						// 시계방향으로 돌린다
						int temp = roll[j][7];
						for (int k = 7; k >= 1; k--) {
							roll[j][k] = roll[j][k-1];
						}
						roll[j][0] = temp;
					} else if(check[j] == -1) {
						// 반시계방향으로 돌린다.
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
