package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_3460_ÀÌÁø¼ö {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < T; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			int count = 0;
			while(N > 0) {
				if(N % 2 == 1) {
					sb.append(count + " ");
				}
				N /= 2;
				count++;
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
}
