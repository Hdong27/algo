package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1159_³ó±¸°æ±â {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] arr = new int[26];
		
		int N = Integer.parseInt(br.readLine().trim());
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			
			arr[s.charAt(0) - 'a']++;
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < 26; i++) {
			if(arr[i] >= 5) {
				sb.append((char)(i + 'a'));
			}
		}
		
		if(sb.length() > 0) {
			System.out.println(sb);
		} else {
			System.out.println("PREDAJA");
		}
	}
}
