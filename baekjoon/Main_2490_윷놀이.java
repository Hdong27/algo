package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2490_¿∑≥Ó¿Ã {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i = 0; i < 3; i++) {
			String s = br.readLine().trim();
			
			int count = 0;
			for (int j = 0; j < 4; j++) {
				if(s.charAt(2 * j) == '0') {
					count++;
				}
			}
			switch(count) {
			case 0:
				System.out.println('E');
				break;
			case 1:
				System.out.println('A');
				break;
			case 2:
				System.out.println('B');
				break;
			case 3:
				System.out.println('C');
				break;
			case 4:
				System.out.println('D');
				break;
			}
		}
	}
}
