package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_10798_세로읽기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[][] map = new char[5][15];
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 15; j++) {
				map[i][j] = '-';
			}
		}
		
		for (int i = 0; i < 5; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < s.length(); j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if(map[j][i] != '-')	System.out.print(map[j][i]);
			}
		}
	}
}
