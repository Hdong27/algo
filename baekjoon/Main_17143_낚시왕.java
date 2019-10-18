package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[R+1][C+1];
		Shark[] sharks = new Shark[M + 1];
		boolean[] dead = new boolean[M + 1];
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sharks[i] = new Shark(Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			map[sharks[i].x][sharks[i].y] = i;
		}
		
		int result = 0;
		
		for (int l = 1; l <= C; l++) {
			// 잡고 상어 이동하고 상어가 먹기
			for (int i = 1; i <= R; i++) {
				if(map[i][l] > 0) {
					result += sharks[map[i][l]].z;
					dead[map[i][l]] = true;
					map[i][l] = 0;
					break;
				}
			}
			
			for (int i = 1; i <= M; i++) {
				if(dead[i]) continue;
				map[sharks[i].x][sharks[i].y] = 0;
			}
			
			for (int i = 1; i <= M; i++) {
				if(dead[i]) continue;
				int s = sharks[i].s;
				if(sharks[i].d == 1 || sharks[i].d == 2) {
					s = sharks[i].s % ((R - 1) * 2);
					if(sharks[i].d == 1) {
						if(sharks[i].x - s < 1) {
							s = 2 + s - sharks[i].x;
							sharks[i].d = 2;
							if(s >= R) {
								s = 2 * R - s;
								sharks[i].d = 1;
							}
						} else {
							s = sharks[i].x - s;
						}
					} else {
                        if (sharks[i].x + s > R) {
                            s = 2 * R - s - sharks[i].x;
                            sharks[i].d = 1;
                            if (s <= 1) {
                                s = 2 - s;
                                sharks[i].d = 2;
                            }
                        } else
                            s = sharks[i].x + s;
					}
					sharks[i].x = s;
				} else {
					s = sharks[i].s % ((C - 1) * 2);
					if(sharks[i].d == 3) {
						if(sharks[i].y + s > C) {
							s = 2 * C - s - sharks[i].y;
							sharks[i].d = 4;
							if(s <= 1) {
								s = 2 - s;
								sharks[i].d = 3;
							}
						} else {
							s = sharks[i].y + s;
						}
					} else {
						if(sharks[i].y - s < 1) {
							s = 2 + s - sharks[i].y;
							sharks[i].d = 3;
							if(s >= C) {
								s = 2 * C - s;
								sharks[i].d = 4;
							}
						} else {
							s = sharks[i].y - s;
						}
					}
					sharks[i].y = s;
				}
				
				
//				for (int j = 0; j < s; j++) {
//					if(sharks[i].d == 1 && sharks[i].x == 1) {
//						sharks[i].d = 2;
//					} else if(sharks[i].d == 2 && sharks[i].x == R) {
//						sharks[i].d = 1;
//					} else if(sharks[i].d == 3 && sharks[i].y == C) {
//						sharks[i].d = 4;
//					} else if(sharks[i].d == 4 && sharks[i].y == 1) {
//						sharks[i].d = 3;
//					}
//					switch(sharks[i].d) {
//					case 1:	// 상
//						sharks[i].x--;
//						break;
//					case 2:	// 하
//						sharks[i].x++;
//						break;
//					case 3:	// 우
//						sharks[i].y++;
//						break;
//					case 4:	// 좌
//						sharks[i].y--;
//						break;
//					}
//				}
			}
			
			for (int i = 1; i <= M; i++) {
				if(dead[i]) continue;
				if(map[sharks[i].x][sharks[i].y] > 0) {
					if(sharks[i].z > sharks[map[sharks[i].x][sharks[i].y]].z) {
						dead[map[sharks[i].x][sharks[i].y]] = true;
						map[sharks[i].x][sharks[i].y] = i;
					} else {
						dead[i] = true;
					}
				} else {
					map[sharks[i].x][sharks[i].y] = i; 
				}
			}
		}
		
		System.out.println(result);
		
	}
	
	static class Shark {
		int x;
		int y;
		int s;	// 속력
		int d;	// 거리
		int z;	// 크기
		
		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
