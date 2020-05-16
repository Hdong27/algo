package kakao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_뉴스클러스터링 {
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2","e=m*c^2"));
	}
	
	public static int solution(String str1, String str2) {
		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		for (int i = 0; i < str1.length() - 1; i++) {
			if(str1.charAt(i) < 'a' || str1.charAt(i) > 'z' || str1.charAt(i+1) < 'a' || str1.charAt(i+1) > 'z') continue;
			list1.add(str1.substring(i, i + 2));
		}
		
		for (int i = 0; i < str2.length() - 1; i++) {
			if(str2.charAt(i) < 'a' || str2.charAt(i) > 'z' || str2.charAt(i+1) < 'a' || str2.charAt(i+1) > 'z') continue;
			list2.add(str2.substring(i, i + 2));
		}
		
		double equal = 0;
		// 교집합
		Collections.sort(list1);
		Collections.sort(list2);
		
		boolean[] check = new boolean[list2.size()];
		for (int i = 0; i < list1.size(); i++) {
			String temp = list1.get(i);
			for (int j = 0; j < list2.size(); j++) {
				if(!check[j] && temp.equals(list2.get(j))) {
					equal++;
					check[j] = true;
					break;
				}
			}
		}
		
		if(list1.size() + list2.size() == equal) {
			return 65536;
		} else if(equal == 0) {
			return 0;
		} else {
			return (int)((equal / (list1.size() + list2.size() - equal)) * 65536);
		}
	}
}
