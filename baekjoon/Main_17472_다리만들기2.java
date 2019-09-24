package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17472_다리만들기2 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			String s = br.readLine().trim();
			for (int j = 0; j < M; j++) {
				map[i][j] = s.charAt(j * 2) - '0';
			}
		}
		
		// 섬을 2, 3, 4로 바꾸기
		int n = 2;
		int[][] q = new int[N*M][2];
		int front = -1;
		int rear = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 1) {
					map[i][j] = n;
					q[++rear] = new int[] {i, j};
					
					while(front < rear) {
						int[] location = q[++front];
						
						for (int k = 0; k < 4; k++) {
							int x = location[0] + dx[k];
							int y = location[1] + dy[k];
							
							if(x >= 0 && y >= 0 && x < N && y < M && map[x][y] == 1) {
								map[x][y] = n;
								q[++rear] = new int[] {x, y};
							}
						}
					}
					
					n++;
				}
			}
		}
		
		List<Line> list = new ArrayList<>();
		int[][] G = new int[n][n];
		
		// 섬마다의 간선을 찾아서 저장하기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] > 0) {
					// 상하좌우로 탐색해서 간선을 list에 저장하기
					// map으로 간선은 하나씩
					
					// x--
					for (int k = i - 1; k >= 0; k--) {
						if(map[k][j] > 0) {
							if(map[k][j] != map[i][j] && i - k - 1 >= 2) {
								G[map[k][j]][map[i][j]] = 1;
								G[map[i][j]][map[k][j]] = 1;
								list.add(new Line(map[i][j], map[k][j], i - k - 1));
							}
							break;
						}
					}
					
					// x++
					for (int k = i + 1; k < N; k++) {
						if(map[k][j] > 0) {
							if(map[k][j] != map[i][j] && k - i - 1 >= 2) {
								G[map[k][j]][map[i][j]] = 1;
								G[map[i][j]][map[k][j]] = 1;
								list.add(new Line(map[i][j], map[k][j], k - i - 1));
							}
							break;
						}
					}
					
					// y--
					for (int k = j - 1; k >= 0; k--) {
						if(map[i][k] > 0) {
							if(map[i][k] != map[i][j] && j - k - 1 >= 2) {
								G[map[i][k]][map[i][j]] = 1;
								G[map[i][j]][map[i][k]] = 1;
								list.add(new Line(map[i][j], map[i][k], j - k - 1));
							}
							break;
						}
					}
					
					// y++
					for (int k = j + 1; k < M; k++) {
						if(map[i][k] > 0) {
							if(map[i][k] != map[i][j] && k - j - 1 >= 2) {
								G[map[i][k]][map[i][j]] = 1;
								G[map[i][j]][map[i][k]] = 1;
								list.add(new Line(map[i][j], map[i][k], k - j - 1));
							}
							break;
						}
					}
				}
			}
		}

		boolean[] visit = new boolean[n];
		int[] q2 = new int[n];
		front = -1;
		rear = -1;
		
		visit[2] = true;
		q2[++rear] = 2;
		
		while(front < rear) {
			int v = q2[++front];
			
			for (int k = 2; k < n; k++) {
				if(G[v][k] > 0 && !visit[k]) {
					visit[k] = true;
					q2[++rear] = k;
				}
			}
		}
		
		boolean flag = true;
		for (int k = 2; k < n; k++) {
			if(!visit[k]) {
				flag = false;
				break;
			}
		}
		
		if(!flag) {
			System.out.println(-1);
		} else {
			Collections.sort(list);
			
			// 큰 간선부터 없애고 간선이 없어져도 되는지 확인한다.
			for (int i = 0; i < list.size(); i++) {
				
				// 지금 가지고 있는 간선을 토대로 그래프 만들기
				for (int j = 2; j < n; j++) {
					for (int k = 2; k < n; k++) {
						G[j][k] = 0;
					}
				}
				
				for (int j = 0; j < list.size(); j++) {
					if(i == j) continue;
					Line line = list.get(j);
					G[line.v1][line.v2] = 1;
					G[line.v2][line.v1] = 1; 
				}
				
				Line line = list.get(i);
				
				visit = new boolean[n];
				q2 = new int[n];
				front = -1;
				rear = -1;
				
				visit[2] = true;
				q2[++rear] = 2;
				
				while(front < rear) {
					int v = q2[++front];
					
					for (int k = 2; k < n; k++) {
						if(G[v][k] > 0 && !visit[k]) {
							visit[k] = true;
							q2[++rear] = k;
						}
					}
				}
				
				flag = true;
				for (int k = 2; k < n; k++) {
					if(!visit[k]) {
						flag = false;
						break;
					}
				}
				
				if(flag) {
					list.remove(i);	// 해당 간선은 없어도 된다.
					i--;
				}
			}
			
			int result = 0;
			for (int i = 0; i < list.size(); i++) {
				result += list.get(i).val;
			}
			
			System.out.println(result);
		}
	}
	
	static class Line implements Comparable<Line>{
		int v1;
		int v2;
		int val;
		
		public Line(int v1, int v2, int val) {
			this.v1 = v1;
			this.v2 = v2;
			this.val = val;
		}

		@Override
		public int compareTo(Line o) {
			return o.val - this.val;
		}
		
		
	}
}
