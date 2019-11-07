package programmers;

public class Solution_문자열압축 {
	public static void main(String[] args) {
		System.out.println(solution("aabbaccc"));
		System.out.println(solution("ababcdcdababcdcd"));
		System.out.println(solution("abcabcdede"));
		System.out.println(solution("abcabcabcabcdededededede"));
		System.out.println(solution("xababcdcdababcdcd"));
	}
	
	static int min;
	
	public static int solution(String s) {
		// 1부터 s.length() / 2 까지를 찾아서 압축가능한지 확인
		// subString
		
		min = Integer.MAX_VALUE;
		function(s, s.length());
		
		
		return min;
	}
	
	static void function(String s, int len) {
		for (int i = 1; i <= len / 2; i++) {
			String[] arr = new String[len % i == 0 ? len / i : len / i + 1];
			int index = 0;
			for (int j = 0; j < len; j += i) {
				arr[index++] = s.substring(j, (j + i >= len ? len : j + i));
			}
			
			for (int j = 0; j < arr.length - 1; j++) {
				if(arr[j].equals(arr[j + 1])) {
					arr[j] = "1";
				}
			}
			
			String temp = "";
			int count = 0;
			for (int j = 0; j < arr.length; j++) {
				if(arr[j].equals("1")) {
					count++;
				} else {
					temp += (count == 0 ? "" : (count + 1)) + arr[j];
					count = 0;
				}
			}
			
			min = temp.length() < min ? temp.length() : min;
		}
	}
}
