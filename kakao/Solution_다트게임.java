package kakao;

import java.util.ArrayList;
import java.util.List;

public class Solution_다트게임 {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
	}
	
	public static int solution(String dartResult) {
		List<Score> list = new ArrayList<>();
		Score score = new Score();
		for (int i = 0; i < dartResult.length(); i++) {
			char temp = dartResult.charAt(i);
			
			if(temp >= '0' && temp <= '9') {
				if(i > 0) list.add(score);
				score = new Score();
				if(temp == '1' && dartResult.charAt(i + 1) == '0') {
					score.num = 10;
					i++;
				} else {
					score.num = temp - '0';
				}
			} else if(temp == 'D' || temp == 'S' || temp == 'T') {
				score.part = temp;
			} else {
				score.option = temp;
			}
		}
		list.add(score);
		
		int[] result = new int[list.size()];
		
		for (int i = 0; i < result.length; i++) {
			score = list.get(i);
			
			switch(score.part) {
			case 'S':
				result[i] = score.num;
				break;
			case 'D':
				result[i] = score.num * score.num;
				break;
			case 'T':
				result[i] = score.num * score.num * score.num;
				break;
			}
			
			if(score.option == '*') {
				if(i > 0) result[i-1] *= 2;
				result[i] *= 2;
			} else if(score.option == '#') {
				result[i] *= -1;
			}
		}
		
		int answer = 0;
		for (int i = 0; i < result.length; i++) {
			answer += result[i];
		}
		
		return answer;
	}
	
	public static class Score {
		int num;
		char part;
		char option;
		
		public Score() {}
		
		@Override
		public String toString() {
			return "[ num : " + num + ", part : " + part + ", option : " + option + " ]";
		}
	}
}
