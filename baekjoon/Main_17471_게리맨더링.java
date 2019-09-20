package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링 {
	static int r;
	static int[] save;
	private static int N;
	private static int[][] G;
	private static int[] num;
	static int result;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine().trim());
		
		G = new int[N][N];
		num = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		// 그래프의 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken()) - 1;
				G[i][v] = 1;
			}
		}
		
		result = Integer.MAX_VALUE;
		
		for (r = 1; r <= N / 2; r++) {
			save = new int[r];
			Comb(0, 0);
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == r) {
			// 그룹이 다 이어져있는지 확인한다.
			isLink();
			return;
		}
		for (int i = start; i < N; i++) {
			save[cnt] = i;
			Comb(cnt+1, i+1);
		}
	}
	
	static void isLink() {
		boolean[] check = new boolean[N];
		for (int i = 0; i < r; i++) {
			check[save[i]] = true;
		}
		// true는 1번 그룹, false는 2번 그룹
		
		int v = 0;
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				v = i;
				break;
			}
		}
		
		// 1번 그룹이 다 이어져 있는지 확인한다.
		boolean[] visit = new boolean[N];
		int[] q = new int[N];
		int front = -1;
		int rear = -1;
		
		visit[v] = true;
		q[++rear] = v;
		
		while(front < rear) {
			int temp = q[++front];
			
			for (int i = 0; i < N; i++) {
				if(G[temp][i] == 1 && !visit[i] && check[i]) {
					visit[i] = true;
					q[++rear] = i;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(check[i] != visit[i]) {
				return;
			}
		}
		
		for (int i = 0; i < N; i++) {
			check[i] = !check[i];
		}

		
		// 2번이 다 이어져있는지 확인한다.
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				v = i;
				break;
			}
		}
		
		visit = new boolean[N];
		q = new int[N];
		front = -1;
		rear = -1;
		
		visit[v] = true;
		q[++rear] = v;
		
		while(front < rear) {
			int temp = q[++front];
			
			for (int i = 0; i < N; i++) {
				if(G[temp][i] == 1 && !visit[i] && check[i]) {
					visit[i] = true;
					q[++rear] = i;
				}
			}
		}
		
		for (int i = 0; i < N; i++) {
			if(check[i] != visit[i]) {
				return;
			}
		}
		
		// 모두 연결되어 있으면
		int sum1 = 0;
		int sum2 = 0;
		for (int i = 0; i < N; i++) {
			if(check[i]) {
				sum1 += num[i];
			} else {
				sum2 += num[i];
			}
		}

		result = result < Math.abs(sum1 - sum2) ? result : Math.abs(sum1 - sum2);
	}
}
