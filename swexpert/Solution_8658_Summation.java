package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_8658_Summation {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			
			for (int i = 0; i < 10; i++) {
				String s = st.nextToken();
				int sum = 0;
				
				for (int j = 0; j < s.length(); j++) {
					sum += s.charAt(j) - '0';
				}
				
				max = sum > max ? sum : max;
				min = sum < min ? sum : min;
			}
			
			System.out.println("#" + t + " " + max + " " + min);
		}
	}
}
