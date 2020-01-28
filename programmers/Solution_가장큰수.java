package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_가장큰수 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {6, 10, 2}));
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
	}

	public static String solution(int[] numbers) {
		String answer = "";

		String[] arr = new String[numbers.length];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(arr, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return (o2 + o1).compareTo(o1 + o2);
			}
		});
		
		for (int i = 0; i < arr.length; i++) {
			answer += arr[i];
		}
		
		return answer.charAt(0) == '0' ? "0" : answer;
	}
}
