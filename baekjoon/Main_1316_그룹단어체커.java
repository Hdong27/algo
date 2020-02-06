package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1316_그룹단어체커 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		int result = 0;
		for (int i = 0; i < N; i++) {
			boolean[] check = new boolean[26];
			String s = br.readLine().trim();
			char temp = s.charAt(0);
			check[temp - 'a'] = true;
			boolean flag = true;
			for (int j = 1; j < s.length(); j++) {
				if(temp == s.charAt(j)) {
					continue;
				} else {
					temp = s.charAt(j);
					if(check[temp - 'a']) {
						flag = false;
						break;
					} else {
						check[temp - 'a'] = true;
					}
				}
			}
			if(flag) result++;
		}
		
		System.out.println(result);
	}
}
