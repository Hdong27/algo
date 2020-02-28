package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1213_String {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 10; t++) {
			int testCase = Integer.parseInt(br.readLine().trim());
			
			String word = br.readLine().trim();
			int len = word.length();
			String line = br.readLine().trim();
			int result = 0;
			
			for (int i = 0; i <= line.length() - len; i++) {
				if(word.equals(line.substring(i, i + len))) {
					result++;
					i += len;
				}
			}
			
			System.out.println("#" + testCase + " " + result);
		}
	}
}