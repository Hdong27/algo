package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17143_낚시왕 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());	// 상어의 수
		
		Shark[] sharks = new Shark[M];
		boolean[] used = new boolean[M];
		int result = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sharks[i] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 1. 사람이 한칸 이동한다. -> i의 인덱스를 하나씩 늘린다.
		for (int i = 1; i <= C; i++) {
			// 2. 그 열에 있는 상어중에 가장 가까운 상어를 잡는다.
			int index = 0;
			int min = R+1;
			for (int j = 0; j < M; j++) {
				if(sharks[j].y == i) {
					if(!used[j] && sharks[j].x < min) {	// 가장 가까운 상어를 찾는다.
						index = j;
						min = sharks[j].x;
					}
				}
			}
			
			if(min < R + 1) {
				used[index] = true;	// 상어를 잡는다.
				result += sharks[index].z;	// 상어의 크기를 확인한다.
			}
			
			Map<String, Integer> map = new HashMap<>();
			// 3. 상어를 속력, 이동 방향으로 이동시킨다.
			for (int j = 0; j < M; j++) {
				if(used[j]) continue;
				int s = 0;
				if(sharks[j].d == 1 || sharks[j].d == 2) {
					s = sharks[j].s % (2 * (R - 1));
				} else {
					s = sharks[j].s % (2 * (C - 1));
				}
				for (int k = 0; k < s; k++) {
					switch(sharks[j].d) {
					case 1:	// 상 : x--
						sharks[j].x--;
						if(sharks[j].x == 0) {
							sharks[j].d = 2;
							sharks[j].x += 2;
						}
						break;
					case 2:	// 하 : x++
						sharks[j].x++;
						if(sharks[j].x == R+1) {
							sharks[j].d = 1;
							sharks[j].x -= 2;
						}
						break;
					case 3:	// 우 : y++
						sharks[j].y++;
						if(sharks[j].y == C+1) {
							sharks[j].d = 4;
							sharks[j].y -= 2;
						}
						break;
					case 4:	// 좌 : y--
						sharks[j].y--;
						if(sharks[j].y == 0) {
							sharks[j].d = 3;
							sharks[j].y += 2;
						}
						break;
					}
				}
				// sharks[j]의 x, y를 저장하는데, 더 큰 값을 저장해 놓고 다른 놈은 true 처리를 한다.
				String temp = sharks[j].x + "," + sharks[j].y;
				if(map.containsKey(temp)) {
					// 상어가 들어있으면
					// 비교해서 큰 상어를 살리자
					if(sharks[map.get(temp)].z > sharks[j].z) {
						used[j] = true;
					} else {
						used[map.get(temp)] = true;
						map.replace(temp, j);
					}
				} else {
					// 상어가 들어있지 않으면
					map.put(temp, j);
				}
			}
		}
		System.out.println(result);
	}
	
	public static class Shark{
		int x;
		int y;
		int s;	// 속력
		int d;	// 이동 방향
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
