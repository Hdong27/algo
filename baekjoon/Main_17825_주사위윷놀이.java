package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_17825_주사위윷놀이 {
	static int max;
	static int[] num;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine().trim();
		
		num = new int[10];
		for (int i = 0; i < 10; i++) {
			num[i] = s.charAt(i * 2) - '0';
		}
		
		max = 0;
		
		String num = "1";
		
//		dfs("1", 1);
		
		for (int a = 1; a <= 2; a++) {
			for (int b = 1; b <= 3; b++) {
				for (int c = 1; c <= 4; c++) {
					for (int d = 1; d <= 4; d++) {
						for (int e = 1; e <= 4; e++) {
							for (int f = 1; f <= 4; f++) {
								for (int g = 1; g <= 4; g++) {
									for (int h = 1; h <= 4; h++) {
										for (int i = 1; i <= 4; i++) {
											function(num + a + b + c + d + e + f + g + h + i);
										}
									}
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	static void dfs(String num, int cnt) {
		if(cnt == 10) {
			function(num);
			return;
		}
		
		for (int i = 1; i <= 4; i++) {
			dfs(num + i, cnt + 1);
		}
	}

	static void function(String s) {
		int sum = 0;
		int[] move = new int[5];
		for (int i = 0; i < 10; i++) {
			int n = s.charAt(i) - '0';	// 1 ~ 4
			if(move[n] == -1) {
				return;
			}
			
			int temp = move[n];
			
			temp = G[temp].next.length > 1 ? G[temp].next[1] : G[temp].next[0];
			for (int j = 1; j < num[i]; j++) {
				if(temp == -1) {
					break;
				}
				temp = G[temp].next[0];
			}
			
			if(temp == -1) {
				move[n] = temp;
				continue;
			}
			
			for (int j = 1; j <= 4; j++) {
				if(n == j || move[n] == -1) continue;
				if(move[j] == temp) {
					return;
				}
			}
			
			// 해당 칸에 말이 없으면
			move[n] = temp;
			sum += G[move[n]].score;
		}
		
		if(sum > max) {
			max = sum;
		}
		
	}
	
	static class Place {
		int[] next;
		int score;
		
		public Place(int[] next, int score) {
			this.next = next;
			this.score = score;
		}
	}
	
	final static Place[] G = {
			new Place(new int[] {1}, 0),	// 시작점
			new Place(new int[] {2}, 2),
			new Place(new int[] {3}, 4),
			new Place(new int[] {4}, 6),
			new Place(new int[] {5}, 8),
			new Place(new int[] {6, 21}, 10),
			new Place(new int[] {7}, 12),
			new Place(new int[] {8}, 14),
			new Place(new int[] {9}, 16),
			new Place(new int[] {10}, 18),
			new Place(new int[] {11, 24}, 20),
			new Place(new int[] {12}, 22),
			new Place(new int[] {13}, 24),
			new Place(new int[] {14}, 26),
			new Place(new int[] {15}, 28),
			new Place(new int[] {16, 26}, 30),
			new Place(new int[] {17}, 32),
			new Place(new int[] {18}, 34),
			new Place(new int[] {19}, 36),
			new Place(new int[] {20}, 38),
			new Place(new int[] {-1}, 40),
			new Place(new int[] {22}, 13),
			new Place(new int[] {23}, 16),
			new Place(new int[] {31}, 19),
			new Place(new int[] {25}, 22),
			new Place(new int[] {31}, 24),
			new Place(new int[] {27}, 28),
			new Place(new int[] {28}, 27),
			new Place(new int[] {31}, 26),
			new Place(new int[] {30}, 30),
			new Place(new int[] {20}, 35),
			new Place(new int[] {29}, 25),
	};
}
