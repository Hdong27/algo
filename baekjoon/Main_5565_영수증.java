package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_5565_¿µ¼öÁõ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int result = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < 9; i++) {
			result -= Integer.parseInt(br.readLine().trim());
		}
		
		System.out.println(result);
	}
}
