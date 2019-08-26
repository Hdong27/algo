package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17406_�迭������4 {
    static int save[]; // ����, �Ǵ� ������ ������ �迭
    static boolean visited[]; // �ߺ� üũ�� ���� �迭
	private static int N;
	private static int M;
	private static int[][] map;
	private static int[][] map2;
	private static int min;
	private static int K;
	private static int[][] rotation;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N+1][M+1];
		map2 = new int[N+1][M+1];
		
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		rotation = new int[K][3];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			rotation[i] = new int[] {Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
		}
		
		min = Integer.MAX_VALUE;
		
		// K���� ������ ���� ������ �����Ǹ� ������ �۾��� �ǽ��Ѵ�.
		save = new int[K];
		visited = new boolean[K];
        Perm(0);
        
        System.out.println(min);
	}
	
	static void Perm(int cnt) {
        if (cnt == K) { // ��������
        	// �迭 save�� ������ ������ �۾��� �ϸ� �ȴ�.
        	move(save);
        	cal();
            return;
        } else {
            for (int i = 1; i <= K; i++) {
                if (visited[i-1] == false) {
                    visited[i-1] = true;
                    save[cnt] = i - 1;
                    Perm(cnt + 1);
                    visited[i-1] = false;
                }
            }
        }
    }
	
	// �ּҰ��� ����ϴ� �޼ҵ�
	static void cal() {
		for (int i = 1; i <= N; i++) {
			int count = 0;
			for (int j = 1; j <= M; j++) {
				count += map2[i][j];
			}
			min = Math.min(min, count);
		}
	}
	
	// �迭�� ������ �۾��� �� �޼ҵ�
	
	static void move(int[] save) {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				map2[i][j] = map[i][j];
			}
		}
		
		for (int i = 0; i < save.length; i++) {
			int[] location = rotation[save[i]];
			int tl = location[0] - location[2];
			int tr = location[1] - location[2];
			int bl = location[0] + location[2];
			int br = location[1] + location[2];
			
			int limit = Math.min(bl - tl, br - tr) / 2;
			
			for (int l = 0; l < limit; l++) {
				int temp = map2[tl+l][br-l];
				for (int j = br-l; j > tr+l; j--) {
					map2[tl+l][j] = map2[tl+l][j-1];
				}
				for (int j = tl+l; j < bl-l; j++) {
					map2[j][tr+l] = map2[j+1][tr+l];
				}
				for (int j = tr+l; j < br-l; j++) {
					map2[bl-l][j] = map2[bl-l][j+1];
				}
				for (int j = bl-l; j > tl+l; j--) {
					map2[j][br-l] = map2[j-1][br-l];
				}
				map2[tl + l + 1][br - l] = temp;
			}
		}
	}
}
