package kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_후보키 {
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {
			{"100","ryan","music","2"},
			{"200","apeach","math","2"},
			{"300","tube","computer","3"},
			{"400","con","computer","4"},
			{"500","muzi","music","3"},
			{"600","apeach","music","2"}
		}));
	}
	
	static int max;
	public static int solution(String[][] relation) {
		max = relation[0].length;
		
		// 조합을 이용한다.
		for (int i = 1; i <= max; i++) {
			m = i;
			save = new int[m];
			check = new boolean[max];
			if(comb(0, 0)) {
				if(function(relation)) break;
			}
			
		}
		
		return m;
	}
	
	static boolean[] check;
	static int[] save;
	static int m;
	public static boolean comb(int index, int count) {
		if(count == m) {
			System.out.println(Arrays.toString(save));
			return true;
		}
		
		for (int i = index; i < max; i++) {
			if(!check[i]) {
				check[i] = true;
				save[count] = i;
				comb(i + 1, count + 1);
				check[i] = false;
			}
		}
		
		return false;
	}
	
	public static boolean function(String[][] relation) {
		// save에 저장되어 있는 것만 가지고 후보키가 될 수 있는지 확인
		System.out.println("function");
		Set<String> hs = new HashSet<>();
		
		for (int i = 0; i < max; i++) {
			String temp = "";
			for (int j = 0; j < save.length; j++) {
				temp += relation[i][save[j]] + " ";
			}
			System.out.println(temp);
			// 전부 다 다른지 확인
			if(hs.add(temp)) {
				return false;
			}
		}
		
		return true;
	}
}
