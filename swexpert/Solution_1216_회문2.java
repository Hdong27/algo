package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1216_È¸¹®2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 0; t < 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			char[][] map = new char[100][100];
			
			for (int i = 0; i < 100; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 100; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			int len = 101;
			boolean flag = true;
loop:		while(flag) {
				len--;
				for (int i = 0; i < 100; i++) {
					for (int j = 0; j <= 100 - len; j++) {
						for (int k = 0; k <= len / 2; k++) {
							if(map[i][j + k] != map[i][j + len - 1 - k]) {
								flag = false;
								break;
							}
						}
						
						if(flag) {
							break loop;
						}
						
						flag = true;
						
						for (int k = 0; k <= len / 2; k++) {
							if(map[j + k][i] != map[j + len - 1 - k][i]) {
								flag = false;
								break;
							}
						}
						
						if(flag) {
							break loop;
						}
						
						flag = true;
					}
				}
				
			}
			
			System.out.println("#" + testCase + " " + len);
		}
	}
}
