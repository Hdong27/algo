package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1223_°è»ê±â2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int N = Integer.parseInt(br.readLine().trim());
			
			String s = br.readLine().trim();
			
			String result = "";
			char[] stack = new char[N];
			int top = -1;
			
			for (int i = 0; i < N; i++) {
				char temp = s.charAt(i);
				
				if(temp >= '0' && temp <= '9') {
					result += temp;
				} else {
					if(top == -1) {
						stack[++top] = temp;
					} else {
						if(temp == '+') {
							for (int j = top; j >= 0; j--) {
								result += stack[j];
							}
							
							top = -1;
							stack[++top] = temp;
						} else {	// temp == '*'
							int index = top - 1;
							for (int j = top; j >= 0; j--) {
								if(stack[j] == '*') {
									result += stack[j];
								} else {
									index = j;
									break;
								}
							}
							
							top = index;
							stack[++top] = temp;
						}
					}
				}
			}
			
			for (int j = top; j >= 0; j--) {
				result += stack[j];
			}
			
			int[] stack2 = new int[N];
			top = -1;
			for (int i = 0; i < N; i++) {
				char temp = result.charAt(i);
				
				if(temp >= '0' && temp <= '9') {
					stack2[++top] = temp - '0';
				} else {
					if(temp == '+') {
						stack2[top - 1] += stack2[top];
						top--;
					} else {
						stack2[top - 1] *= stack2[top];
						top--;
					}
				}
				
			}
			
			System.out.println("#" + t + " " + stack2[0]);
		}
	}
}
