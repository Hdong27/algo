package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_1218_°ýÈ£Â¦Áþ±â {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			int len = Integer.parseInt(br.readLine().trim());
			
			char[] stack = new char[len];
			int top = -1;
			boolean flag = true;
			
			String s = br.readLine().trim();
			for (int i = 0; i < len; i++) {
				char temp = s.charAt(i);
				
				if(temp == '(' || temp == '{' || temp == '[' || temp == '<') {
					stack[++top] = temp;
				} else {
					if(temp == ')') {
						if(stack[top] == '(') {
							top--;
						} else {
							flag = false;
							break;
						}
					} else if(temp == '}') {
						if(stack[top] == '{') {
							top--;
						} else {
							flag = false;
							break;
						}
					} else if(temp == ']') {
						if(stack[top] == '[') {
							top--;
						} else {
							flag = false;
							break;
						}
					} else if(temp == '>') {
						if(stack[top] == '<') {
							top--;
						} else {
							flag = false;
							break;
						}
					}
				}
			}
			
			if(flag) {
				System.out.println("#" + t + " 1");
			} else {
				System.out.println("#" + t + " 0");
			}
		}
	}
}
