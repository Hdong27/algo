package programmers;

public class Solution_가운데글자가져오기 {
	public String solution(String s) {
		if(s.length() % 2 == 1) {
			return String.valueOf(s.charAt(s.length() / 2));
		} else {
			return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
		}
	}
}
