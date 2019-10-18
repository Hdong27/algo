package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2231_ºÐÇØÇÕ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		boolean flag = true;
		
		for (int i = 1; i < N; i++) {
			String s = String.valueOf(i);
			
			int sum = i;
			
			for (int j = 0; j < s.length(); j++) {
				sum += s.charAt(j) - '0';
			}
			
			if(sum == N) {
				flag = false;
				System.out.println(i);
				break;
			}
		}
		
		if(flag) {
			System.out.println(0);
		}
	}
}
