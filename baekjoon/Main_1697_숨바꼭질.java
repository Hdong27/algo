package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1697_¼û¹Ù²ÀÁú {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean[] visit = new boolean[100001];
		
		int[] q = new int[100001];
		int front = -1;
		int rear = -1;
		
		visit[N] = true;
		q[++rear] = N;
		
		int result = 0;
loop:	while(front < rear) {
			
			int start = front;
			int end = rear;
			
			for (int i = start; i < end; i++) {
				int c = q[++front];
				
				if(c == K) break loop;
				
				if(c+1 <= 100000 && !visit[c+1]) {
					visit[c+1] = true;
					q[++rear] = c+1;
				}
				if(c-1 >= 0 && !visit[c-1]) {
					visit[c-1] = true;
					q[++rear] = c-1;
				}
				if(2*c <= 100000 && !visit[c*2]) {
					visit[2*c] = true;
					q[++rear] = 2*c;
				}
			}
			result++;
		}
		
		System.out.println(result);
	}
}
