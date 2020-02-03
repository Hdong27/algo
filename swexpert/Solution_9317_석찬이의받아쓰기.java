package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_9317_석찬이의받아쓰기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			String answer = br.readLine().trim();
			String write = br.readLine().trim();
			
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				if(answer.charAt(i) == write.charAt(i)) {
					result++;
				}
			}
			
			System.out.println("#" + t + " " + result);
		}
		
	}
}
