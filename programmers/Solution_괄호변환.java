package programmers;

public class Solution_괄호변환 {
	public static void main(String[] args) {
		System.out.println(solution("(()())()"));
		System.out.println(solution(")("));
		System.out.println(solution("()))((()"));
	}
	
	public static String solution(String s) {
		if(isTrue(s)) {
			return s;
		}
		
		// 문자열이 올바르지 않을때 올바르게 바꿔준다.
		// 1. 문자열을 두개로 분리한다.
		int cntU = 0;
		int cntV = 0;
		String u = "";
		String v = "";
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				cntU++;
			} else {
				cntV++;
			}
			
			u += s.charAt(i);
			
			if(cntU > 0 && cntV > 0 && cntU == cntV) {
				for (int j = i + 1; j < s.length(); j++) {
					v += s.charAt(j);
				}
				break;
			}
		}
		
		if(isTrue(u)) {
			return u + solution(v);
		} else {
			String temp = '(' + solution(v) + ')';
			String temp2 = "";
			for (int i = 1; i < u.length() - 1; i++) {
				temp2 += u.charAt(i) == ')' ? '(' : ')';
			}
			return temp + temp2;
		}
	}
	
	static boolean isTrue(String s) {
		char[] stack = new char[s.length()];
		int top = -1;
		
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				stack[++top] = s.charAt(i);
			} else {
				if(top < 0) {
					return false;
				} else {
					top--;
				}
			}
		}
		return true;
	}
}
