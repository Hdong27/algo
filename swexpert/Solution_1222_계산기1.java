package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1222_°è»ê±â1 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			String s = br.readLine().trim();
			
			int result = 0;
			for (int i = 0; i < N; i += 2) {
				result += s.charAt(i) - '0';
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
