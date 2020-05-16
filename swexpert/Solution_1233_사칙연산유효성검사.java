package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			boolean flag = true;
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				if(!flag) continue;
				
				int index = Integer.parseInt(st.nextToken());
				
				char data = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					// +, -, *, /
					if(data >= '0' && data <= '9') {
						flag = false;
					}
				} else {
					// 숫자
					if(data < '0' || data > '9') {
						flag = false;
					}
				}
			}
			
			System.out.println("#" + t + " " + (flag ? 1 : 0));
		}
	}
}
