package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_8931_Á¦·Î {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine().trim());
			
			int[] stack = new int[100001];
			int top = -1;
			
			for (int i = 0; i < K; i++) {
				int temp = Integer.parseInt(br.readLine().trim());
				if(temp == 0) {
					top--;
				} else {
					stack[++top] = temp;
				}
			}
			
			int result = 0;
			for (int i = 0; i <= top; i++) {
				result += stack[i];
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
