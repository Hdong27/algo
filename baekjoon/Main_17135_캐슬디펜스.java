package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17135_캐슬디펜스 {
	private static int N;
	private static int M;
	private static int D;
	private static int[][] map;
	private static int r;
	private static int[] save;
	private static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
			}
		}
		
		r = 3;
		save = new int[r];
		result = 0;
		
		Comb(0, 0);
		
		System.out.println(result);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == r) {
			function();
			return;
		}
		
		for (int i = start; i < M; i++) {
			save[cnt] = i;
			Comb(cnt + 1, i + 1);
		}
	}
	
	static void function() {
		int[][] map2 = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		int count = 0;
		// 시간 별로 진행한다.
		for (int x = N; x > 0; x--) {
			// 궁수가 잡을 수 있는 적을 기록한다.
			int[][] die = new int[3][2];
			int index = 0;
			for (int i = 0; i < 3; i++) {
				int y = save[i];
				int[] target = {N, M};
				int min = D;
				
				for (int j = 0; j < x; j++) {
					for (int k = 0; k < M; k++) {
						if(map2[j][k] == 1) {
							int dir = Math.abs(x - j) + Math.abs(y - k);
							if(min > dir) {
								min = dir;
								target = new int[] {j, k};
							} else if(min == dir) {
								if(k < target[1]) {
									target = new int[] {j, k};
								}
							}
						}
					}
				}
				
				if(target[1] != M) {
					die[index++] = new int[] {target[0], target[1]};
				}
			}
			
			// 궁수가 잡은 적을 없애고 더한다.
			for (int i = 0; i < index; i++) {
				if(map2[die[i][0]][die[i][1]] == 1) {
					count++;
					map2[die[i][0]][die[i][1]] = 0;
				}
			}
			
		}
		result = result > count ? result : count;
	}
}
