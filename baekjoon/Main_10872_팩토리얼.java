package baekjoon;

import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main_10872_ÆÑÅä¸®¾ó {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int result = 1;
		
		for (int i = 2; i <= N; i++) {
			result *= i;
		}
		
		System.out.println(result);
	}
}
