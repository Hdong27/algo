package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_17143_���ÿ� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int M = Integer.parseInt(st.nextToken());	// ����� ��
		
		Shark[] sharks = new Shark[M];
		boolean[] used = new boolean[M];
		int result = 0;
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			sharks[i] = new Shark(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		// 1. ����� ��ĭ �̵��Ѵ�. -> i�� �ε����� �ϳ��� �ø���.
		for (int i = 1; i <= C; i++) {
			// 2. �� ���� �ִ� ����߿� ���� ����� �� ��´�.
			int index = 0;
			int min = R+1;
			for (int j = 0; j < M; j++) {
				if(sharks[j].y == i) {
					if(!used[j] && sharks[j].x < min) {	// ���� ����� �� ã�´�.
						index = j;
						min = sharks[j].x;
					}
				}
			}
			
			if(min < R + 1) {
				used[index] = true;	// �� ��´�.
				result += sharks[index].z;	// ����� ũ�⸦ Ȯ���Ѵ�.
			}
			
			Map<String, Integer> map = new HashMap<>();
			// 3. �� �ӷ�, �̵� �������� �̵���Ų��.
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
					case 1:	// �� : x--
						sharks[j].x--;
						if(sharks[j].x == 0) {
							sharks[j].d = 2;
							sharks[j].x += 2;
						}
						break;
					case 2:	// �� : x++
						sharks[j].x++;
						if(sharks[j].x == R+1) {
							sharks[j].d = 1;
							sharks[j].x -= 2;
						}
						break;
					case 3:	// �� : y++
						sharks[j].y++;
						if(sharks[j].y == C+1) {
							sharks[j].d = 4;
							sharks[j].y -= 2;
						}
						break;
					case 4:	// �� : y--
						sharks[j].y--;
						if(sharks[j].y == 0) {
							sharks[j].d = 3;
							sharks[j].y += 2;
						}
						break;
					}
				}
				// sharks[j]�� x, y�� �����ϴµ�, �� ū ���� ������ ���� �ٸ� ���� true ó���� �Ѵ�.
				String temp = sharks[j].x + "," + sharks[j].y;
				if(map.containsKey(temp)) {
					// �� ���������
					// ���ؼ� ū �� �츮��
					if(sharks[map.get(temp)].z > sharks[j].z) {
						used[j] = true;
					} else {
						used[map.get(temp)] = true;
						map.replace(temp, j);
					}
				} else {
					// �� ������� ������
					map.put(temp, j);
				}
			}
		}
		System.out.println(result);
	}
	
	public static class Shark{
		int x;
		int y;
		int s;	// �ӷ�
		int d;	// �̵� ����
		int z;	// ũ��
		
		public Shark(int x, int y, int s, int d, int z) {
			this.x = x;
			this.y = y;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
}
