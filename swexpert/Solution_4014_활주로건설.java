package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로건설 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());	// 맵의 크기
			int X = Integer.parseInt(st.nextToken());	// 경사로의 길이
			
			int[][] map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = br.readLine().trim();
				for (int j = 0; j < N; j++) {
					map[i][j] = s.charAt(j * 2) - '0';
				}
			}
			
			// 모든 길에 대해 탐색하면서 경사로로 쓸수 있는 길이 몇개 인지 센다
			int result = 0;
			
			for (int i = 0; i < N; i++) {
				boolean flag = true;
				int prev = map[i][0];
				int count = 1;
loop1:			for (int j = 1; j < N; j++) {
					if(map[i][j] == prev) {
						// 같은 숫자를 만나면 count를 증가
						count++;
					} else if(map[i][j] == prev + 1) {
						// count를 확인해서 경사를 세울수 있으면 가능 아니면 끝낸다.
						if(count >= X) {
							prev = map[i][j];
							count = 1;
						} else {
							flag = false;
							break;
						}
					} else if(map[i][j] == prev - 1) {	// map[i][j] < prev
						// 다음 블록들에 경사를 세울 수 있는지 확인을한다.
						for (int k = j + 1; k < j + X; k++) {
							if(k >= N || map[i][k] != map[i][j]) {
								flag = false;
								break loop1;
							}
						}
						j += X - 1;
						prev = map[i][j];
						count = 0;
					} else {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					result++;
				}
				
				flag = true;
				prev = map[0][i];
				count = 1;
loop2:			for (int j = 1; j < N; j++) {
					if(map[j][i] == prev) {
						// 같은 숫자를 만나면 count를 증가
						count++;
					} else if(map[j][i] == prev + 1) {
						// count를 확인해서 경사를 세울수 있으면 가능 아니면 끝낸다.
						if(count >= X) {
							prev = map[j][i];
							count = 1;
						} else {
							flag = false;
							break;
						}
					} else if(map[j][i] == prev - 1) {	// map[j][i] < prev
						// 다음 블록들에 경사를 세울 수 있는지 확인을한다.
						for (int k = j + 1; k < j + X; k++) {
							if(k >= N || map[k][i] != map[j][i]) {
								flag = false;
								break loop2;
							}
						}
						j += X - 1;
						prev = map[j][i];
						count = 0;
					} else {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					result++;
				}
				
			}
			
			System.out.println("#" + t + " " + result);
		}
	}
}
