package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1224_°è»ê±â3 {
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
				} else if(temp == '+') {
					if(top == -1 || stack[top] == '(') {
						stack[++top] = temp;
					} else {
						while(top >= 0) {
							if(stack[top] == '+' || stack[top] == '*') {
								result += stack[top];
							} else {
								break;
							}
							top--;
						}
						stack[++top] = temp;
					}
				} else if(temp == '*') {
					if(top == -1 || stack[top] == '(') {
						stack[++top] = temp;
					} else {
						while(top >= 0) {
							if(stack[top] == '*') {
								result += stack[top--];
							} else {
								break;
							}
						}
						stack[++top] = temp;
					}
				} else if(temp == '(') {
					stack[++top] = temp;
				} else if(temp == ')') {
					while(top >= 0) {
						if(stack[top] == '(') {
							top--;
							break;
						} else {
							result += stack[top];
						}
						top--;
					}
				}
			}
			
			for (int i = top; i >= 0; i--) {
				result += stack[i];
			}
			
			int[] stack2 = new int[N];
			top = -1;
			
			for (int i = 0; i < result.length(); i++) {
				char temp = result.charAt(i);
				
				if(temp >= '0' && temp <= '9') {
					stack2[++top] = temp - '0';
				} else if(temp == '+') {
					stack2[top - 1] += stack2[top--];
				} else if(temp == '*') {
					stack2[top - 1] *= stack2[top--];
				}
			}
			
			System.out.println("#" + t + " " + stack2[0]);
		}
	}
}
