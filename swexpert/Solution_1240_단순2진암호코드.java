package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1240_단순2진암호코드 {
	static String[] com = {
			"0001101",
			"0011001",
			"0010011",
			"0111101",
			"0100011",
			"0110001",
			"0101111",
			"0111011",
			"0110111",
			"0001011"
	};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			boolean flag = false;
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine();
				
				if(flag) {
					continue;
				}
				
				int[] arr = new int[8];
				if(s.contains("1")) {
					flag = true;
					
					int index = s.length();
					
					for (int j = s.length() - 1; j >= 0; j--) {
						if(s.charAt(j) == '1') {
							index = j + 1;
							break;
						}
					}
					
					int index2 = 7;
					for (int j = index; j >= 0 && index2 >= 0; j -= 7) {
						for (int k = 0; k < 10; k++) {
							if(s.substring(j - 7, j).equals(com[k])) {
								arr[index2--] = k;
								break;
							}
						}
					}
					
					int temp = 0;
					for (int j = 0; j < 8; j++) {
						if(j % 2 == 0) {
							temp += arr[j] * 3;
						} else {
							temp += arr[j];
						}
					}
					if(temp % 10 == 0) {
						int sum = 0;
						for (int j = 0; j < 8; j++) {
							sum += arr[j];
						}
						System.out.println("#" + t + " " + sum);
					} else {
						System.out.println("#" + t + " 0");
					}
				}
			}
		}
	}
}
