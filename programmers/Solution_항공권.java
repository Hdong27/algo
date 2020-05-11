package programmers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution_항공권 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[][] {
			{"ICN", "JFK"}, 
			{"HND", "IAD"}, 
			{"JFK", "HND"}
		})));
		
		System.out.println(Arrays.toString(solution(new String[][] {
			{"ICN", "SFO"}, 
			{"ICN", "ATL"}, 
			{"SFO", "ATL"}, 
			{"ATL", "ICN"}, 
			{"ATL", "SFO"}
		})));
	}
	
	static String[] answer;
	static boolean[] check;
	static int N;
	static String result;
	public static String[] solution(String[][] tickets) {
		N = tickets.length;
		
		Arrays.sort(tickets, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				for (int i = 0; i < 3; i++) {
					if(o1[0].charAt(i) > o2[0].charAt(i)) {
						return 1;
					} else if(o2[0].charAt(i) > o1[0].charAt(i)) {
						return -1;
					}
				}
				
				for (int i = 0; i < 3; i++) {
					if(o1[1].charAt(i) > o2[1].charAt(i)) {
						return 1;
					} else if(o2[1].charAt(i) > o1[1].charAt(i)) {
						return -1;
					}
				}
				return 1;
			}
		});
		
		check = new boolean[N];
		
		result = "NONE";
		dfs(1, "ICN", tickets, "ICN ");
		
		answer = result.split(" ");
		
		return answer;
	}
	
	public static void dfs(int index, String point, String[][] tickets, String dir) {
		if(index == N + 1) {
			if(result.equals("NONE")) {
				result = dir;
			} else {
				// 비교
				for (int i = 0; i < result.length(); i++) {
					if(result.charAt(i) != dir.charAt(i)) {
						if(result.charAt(i) > dir.charAt(i)) {
							result = dir;
						}
						break;
					}
				}
			}
			
			return;
		}
		
		for (int i = 0; i < tickets.length; i++) {
			if(!check[i] && point.equals(tickets[i][0])) {
				check[i] = true;
				dfs(index + 1, tickets[i][1], tickets, dir + tickets[i][1] + " ");
				check[i] = false;
			}
		}
	}
}
