package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5597_과제안내신분 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] arr = new boolean[31];
		
		for (int i = 0; i < 28; i++) {
			arr[Integer.parseInt(br.readLine().trim())] = true;
		}
		
		for (int i = 1; i <= 30; i++) {
			if(!arr[i])	System.out.println(i);
		}
	}
}
