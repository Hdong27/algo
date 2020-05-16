package programmers;

public class Solution_2016³â {
	public static void main(String[] args) {
		System.out.println(solution(1, 1));
		System.out.println(solution(5, 24));
	}
	
	public static String solution(int a, int b) {
		String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
		int[] num = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		int temp = 0;
		
		for (int i = 1; i < a; i++) {
			temp += num[i];
		}
		
		temp += b - 1;
		
		temp %= 7;
		
		return day[temp];
	}
}
