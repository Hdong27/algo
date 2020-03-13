package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1238_Contact {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int len = N / 2;
			st = new StringTokenizer(br.readLine(), " ");
			
			boolean[][] map = new boolean[101][101];
			
			for (int i = 0; i < len; i++) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				map[start][end] = true;
			}
			
			int max = 0;
			boolean[] check = new boolean[101];
			
			int[] q = new int[len];
			int front = -1;
			int rear = -1;
			
			q[++rear] = K;
			check[K] = true;
			while(front < rear) {
				int start = front;
				int end = rear;
				max = 0;
				
				for (int i = start; i < end; i++) {
					int v = q[++front];
					max = v > max ? v : max;
					
					for (int j = 1; j <= 100; j++) {
						if(map[v][j] && !check[j]) {
							check[j] = true;
							q[++rear] = j;
						}
					}
				}
			}
			
			System.out.println("#" + t + " " + max);
		}
	}
}
