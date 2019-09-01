package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_5356_의석이의세로로말해요 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= T; t++) {
			
			char[][] map = new char[5][15];
			int max = 0;
			
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 15; j++) {
					map[i][j] = '-';
				}
			}
			
			for (int i = 0; i < 5; i++) {
				String s = br.readLine().trim();
				int index = s.length();
				max = max < index ? index : max;
				for (int j = 0; j < index; j++) {
					map[i][j] = s.charAt(j);
				}
			}
			
			sb.append('#').append(t).append(' ');
			
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < 5; j++) {
					if(map[j][i] == '-') continue;
					sb.append(map[j][i]);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
