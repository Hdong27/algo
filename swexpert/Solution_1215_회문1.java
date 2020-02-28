package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1215_È¸¹®1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			char[][] map = new char[8][8];
			
			for (int i = 0; i < 8; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < 8; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			int result = 0;
			
			for (int i = 0; i < 8; i++) {
				for (int j = 0; j <= 8 - N; j++) {
					// map[i][j] ~ map[i][j + N - 1 - k]
					boolean flag = true;
					for (int k = 0; k <= N / 2; k++) {
						if(map[i][j + k] != map[i][j + N - 1 - k]) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						result++;
					}
					
					flag = true;
					for (int k = 0; k <= N / 2; k++) {
						if(map[j + k][i] != map[j + N - 1 - k][i]) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						result++;
					}
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
