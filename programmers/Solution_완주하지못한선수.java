package programmers;

import java.util.HashMap;
import java.util.Map;

public class Solution_완주하지못한선수 {
	public static void main(String[] args) {
		
	}
	
	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> hm = new HashMap<>();
		
		for (int i = 0; i < completion.length; i++) {
			if(hm.containsKey(completion[i])) {
				hm.put(completion[i], hm.get(completion[i]) + 1);
			} else {
				hm.put(completion[i], 1);
			}
		}
		
		for (int i = 0; i < participant.length; i++) {
			if(hm.containsKey(participant[i]) && hm.get(participant[i]) > 0) {
				hm.put(participant[i], hm.get(participant[i]) - 1);
			} else {
				return participant[i];
			}
		}
		
		return "";
	}
}
