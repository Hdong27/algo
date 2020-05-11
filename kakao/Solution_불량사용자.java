package kakao;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution_불량사용자 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "abc1**"}));
		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"*rodo", "*rodo", "******"}));
		System.out.println(solution(new String[] {"frodo", "fradi", "crodo", "abc123", "frodoc"}, new String[] {"fr*d*", "*rodo", "******", "******"}));
	}
	
	static boolean[][] check;
	static boolean[] possible;
	static int N, M, answer;
	static Set<String> hs;
	public static int solution(String[] user_id, String[] banned_id) {
		hs = new HashSet<String>();
		answer = 0;
		N = banned_id.length;
		M = user_id.length;
		check = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			String temp = banned_id[i];
			for (int j = 0; j < M; j++) {
				String com = user_id[j];
				
				// temp, com을 비교해서 같은지 확인한다
				if(temp.length() == com.length()) {
					boolean flag = true;
					for (int k = 0; k < temp.length(); k++) {
						if(temp.charAt(k) != '*' && temp.charAt(k) != com.charAt(k)) {
							flag = false;
							break;
						}
					}
					
					if(flag) {	// 같으면
						check[i][j] = true;
					}
				}
			}
		}
		
		// check를 이용해 가능한 조합을 짠다.
		possible = new boolean[M];
		comb(0, 0);
		
		return answer;
	}
	
	public static void comb(int n, int m) {
		if(n == N) {
			String temp = "";
			for (int i = 0; i < M; i++) {
				if(possible[i]) {
					temp += i + " ";
				}
			}
			if(hs.add(temp)) {
				answer++;
			}
			return;
		}
		
		for (int i = n; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(check[i][j] && !possible[j]) {
					possible[j] = true;
					comb(i+1, j+1);
					possible[j] = false;
				}
			}
			return;
		}
	}
}
