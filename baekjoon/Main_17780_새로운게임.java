package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17780_새로운게임 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+2][N+2];
		String[][] loc = new String[N+2][N+2];
		
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				loc[i][j] = "";
			}
		}
		
		for (int i = 0; i < N + 2; i++) {
			map[0][i] = 2;
			map[i][0] = 2;
			map[N + 1][i] = 2;
			map[i][N + 1] = 2;
		}
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine().trim();
			for (int j = 1; j <= N; j++) {
				map[i][j] = s.charAt((j - 1) * 2) -'0';
			}
		}
		
		List<Piece> list = new ArrayList<>();
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			list.add(new Piece(x, y, d));
			loc[x][y] = i + "";
		}
		
		// 0 : 그냥 진행
		// 1 : 해당 자리의 체스말 위치 바꿈
		// 2 : 이동방향 바꾸고 한칸 더 -- 반대도 2일 경우 방향만 바꾼다
		int result = 0;
		
z:		while(result <= 1000) {
			result++;
			// 순서대로 이동을 시킨다.
			for (int i = 0; i < K; i++) {
				Piece p = list.get(i);
				int index = loc[p.x][p.y].charAt(0) - '0';
				if(index != i) continue;	// 가장 아래에 있는 돌이 아니면 움직이지 않는다.
				
				String temp = loc[p.x][p.y];
				loc[p.x][p.y] = "";
				
				switch(p.d) {
				case 1:
					p.y++;
					break;
				case 2:
					p.y--;
					break;
				case 3:
					p.x--;
					break;
				case 4:
					p.x++;
					break;
				}
				
				if(map[p.x][p.y] == 1) {
					if(temp.length() > 1) {
						for (int j = 1; j < temp.length(); j++) {
							list.get(temp.charAt(j) - '0').x = p.x;
							list.get(temp.charAt(j) - '0').y = p.y;
						}
						// temp를 반전 시킨다.
						String temp2 = "";
						for (int j = temp.length() - 1; j >= 0; j--) {
							temp2 += temp.charAt(j);
						}
						temp = temp2;
					}
				} else if(map[p.x][p.y] == 2) {
					boolean flag = true;
					switch(p.d) {
					case 1:
						p.d = 2;
						if(map[p.x][p.y-2] == 2) {
							p.y--;
							flag = false;
						} else {
							p.y -= 2;
						}
						break;
					case 2:
						p.d = 1;
						if(map[p.x][p.y+2] == 2) {
							p.y++;
							flag = false;
						} else {
							p.y += 2;
						}
						break;
					case 3:
						p.d = 4;
						if(map[p.x+2][p.y] == 2) {
							p.x++;
							flag = false;
						} else {
							p.x += 2;
						}
						break;
					case 4:
						p.d = 3;
						if(map[p.x-2][p.y] == 2) {
							p.x--;
							flag = false;
						} else {
							p.x -= 2;
						}
						break;
					}
					
					if(flag && temp.length() > 1) {
						for (int j = 1; j < temp.length(); j++) {
							int n = temp.charAt(j) - '0';
							list.get(n).x = p.x;
							list.get(n).y = p.y;
						}
						
						if(map[p.x][p.y] == 1) {
							// temp를 반전 시킨다.
							String temp2 = "";
							for (int j = temp.length() - 1; j >= 0; j--) {
								temp2 += temp.charAt(j);
							}
							temp = temp2;
						}
					}
				} else {
					if(temp.length() > 1) {
						for (int j = 1; j < temp.length(); j++) {
							int n = temp.charAt(j) - '0';
							list.get(n).x = p.x;
							list.get(n).y = p.y;
						}
					}
				}
				
				loc[p.x][p.y] += temp;
			}
			
			for (Piece p : list) {
				if(loc[p.x][p.y].length() >= 4) {
					break z;
				}
			}
		}
		
//		for (Piece p : list) {
//			System.out.println(p.x + ", " + p.y + " : " + p.d);
//		}
		
		System.out.println(result > 1000 ? -1 : result);
	}
	
	static class Piece {
		int x;
		int y;
		int d;	// 이동방향 (1 : 우, 2 : 좌, 3 : 상, 4 : 하)
		
		public Piece(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
}
