package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1926_간단한369게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 1; i <= N; i++) {
			String temp = String.valueOf(i);
			
			int count = 0;
			for (int j = 0; j < temp.length(); j++) {
				if(temp.charAt(j) == '3' || temp.charAt(j) == '6' || temp.charAt(j) == '9') {
					count++;
				}
			}
			
			if(count > 0) {
				while(count > 0) {
					System.out.print("-");
					count--;
				}
				System.out.print(" ");
			} else {
				System.out.print(i + " ");
			}
			
		}
	}
}
