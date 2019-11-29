package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1789_수들의합 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long S = Long.parseLong(br.readLine().trim());
		long N = 0;
		long i = 1;
		
		while(S > 0) {
			S -= i++;
			N++;
		}
		
		System.out.println(S == 0 ? N : N - 1);
	}
}
