package kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_Æ©ÇÃ {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
		System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
		System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
	}
	
	public static int[] solution(String s) {
		s = s.substring(1, s.length() - 1);
		
		List<int[]> list = new ArrayList<>();
		
		int index = 0;
		while(index < s.length()) {
			if(s.charAt(index) == '{') {
				String temp = "";
				index++;
				while(s.charAt(index) != '}') {
					temp += s.charAt(index);
					index++;
				}
				StringTokenizer st = new StringTokenizer(temp, ",");
				int[] temp2 = new int[st.countTokens()];
				
				for (int i = 0; i < temp2.length; i++) {
					temp2[i] = Integer.parseInt(st.nextToken());
				}
				
				list.add(temp2);
			}

			index++;
		}
		
		Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1.length - o2.length;
			}
		});
		
		Set<Integer> hs = new HashSet<>();
		int[] answer = new int[list.get(list.size() - 1).length];
		
		for (int i = 0; i < list.size(); i++) {
			int[] temp = list.get(i);
			
			for (int j = 0; j < temp.length; j++) {
				if(hs.add(temp[j])) {
					answer[i] = temp[j];
					break;
				}
			}
		}
		
		return answer;
	}
}
