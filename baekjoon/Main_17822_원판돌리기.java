package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17822_���ǵ����� {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());	// ���
			int d = Integer.parseInt(st.nextToken());	// ���� - 0 : �ð�, 1 : �ݽð�
			int k = Integer.parseInt(st.nextToken()) % M;	// ȸ�� ��
			
			for (int j = x - 1; j < N; j += x) {
				if(d == 0) {	// �ð� ����
					for (int l = 0; l < k; l++) {
						int temp = map[j][M-1];
						for (int o = M - 1; o > 0; o--) {
							map[j][o] = map[j][o-1];
						}
						map[j][0] = temp;
					}
				} else {	// �ݽð� ����
					for (int l = 0; l < k; l++) {
						int temp = map[j][0];
						for (int o = 0; o < M - 1; o++) {
							map[j][o] = map[j][o+1];
						}
						map[j][M-1] = temp;
					}
				}
			}
			
			// ������ ���� �����Ѵ�.
			int[][] q = new int[N*M][2];
			int rear = -1;
			
			for (int j = 0; j < N; j++) {
				for (int l = 0; l < M; l++) {
					if(map[j][l] == 0) continue;
					for (int o = 0; o < 4; o++) {
						if(j == 0 && o == 0) continue;
						if(j == N - 1 && o == 1) continue;
						int x2 = j + dx[o];
						int y2 = l + dy[o];
						
						if(x2 == -1) {
							x2 = N - 1;
						} else if (x2 == N) {
							x2 = 0;
						}
						
						if(y2 == -1) {
							y2 = M - 1;
						} else if (y2 == M) {
							y2 = 0;
						}
						
						if(map[j][l] == map[x2][y2]) {
							q[++rear] = new int[] {j, l};
							break;
						}
					}
				}
			}
			
			if(rear >= 0) {
				for (int j = 0; j <= rear; j++) {
					map[q[j][0]][q[j][1]] = 0;
				}
			} else {
				// ������ ���� ������ ��ü ����� ����ؼ� ��պ��� ū ���� -1, ���� ���� +1
				int count = 0;
				int sum = 0;
				
				for (int j = 0; j < N; j++) {
					for (int l = 0; l < M; l++) {
						if(map[j][l] > 0) {
							count++;
							sum += map[j][l];
						}
					}
				}
				
				double avg = (double)sum / count;
				
				for (int j = 0; j < N; j++) {
					for (int l = 0; l < M; l++) {
						if(map[j][l] > 0) {
							if(map[j][l] < avg) {
								map[j][l]++;
							} else if(map[j][l] > avg){
								map[j][l]--;
							}
						}
					}
				}
			}
			
		}
		
		int result = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				result += map[i][j];
			}
		}
		
		System.out.println(result);
	}
}
