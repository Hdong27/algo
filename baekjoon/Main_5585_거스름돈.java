package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5585_°Å½º¸§µ· {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 1000 - Integer.parseInt(br.readLine().trim());
		
		int result = 0;
		
		while(N >= 500) {
			result++;
			N -= 500;
		}
		
		while(N >= 100) {
			result++;
			N -= 100;
		}
		
		while(N >= 50) {
			result++;
			N -= 50;
		}
		
		while(N >= 10) {
			result++;
			N -= 10;
		}
		
		while(N >= 5) {
			result++;
			N -= 5;
		}
		
		result += N;
		
		System.out.println(result);
	}
}
