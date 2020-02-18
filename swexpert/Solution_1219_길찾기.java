package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1219_±Ê√£±‚ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int testCase = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] road = new int[100][3];
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < K; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				road[a][++road[a][0]] = b;
			}
			
			// bfs
			boolean flag = false;
			boolean[] check = new boolean[100];
			int[] q = new int[100];
			int front = -1;
			int rear = -1;
			q[++rear] = 0;
			check[0] = true;
			
			while(front < rear) {
				int v = q[++front];
				
				if(v == 99) {
					flag = true;
					break;
				}
				
				for (int i = 1; i <= road[v][0]; i++) {
					if(!check[road[v][i]]) {
						q[++rear] = road[v][i];
						check[road[v][i]] = true;
					}
				}
			}
			
			if(flag) {
				System.out.println("#" + testCase + " 1");
			} else {
				System.out.println("#" + testCase + " 0");
			}
		}
	}
}
