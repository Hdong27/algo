package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1232_사칙연산 {
	static StringTokenizer st;
	static Node[] arr;
	static int N;
	static int[] stack;
	static int top;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			arr = new Node[N + 1];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int index = Integer.parseInt(st.nextToken());
				String data = st.nextToken();
				int left = -1;
				int right = -1;
				if(st.hasMoreTokens()) {
					left = Integer.parseInt(st.nextToken());
					if(st.hasMoreTokens()) {
						right = Integer.parseInt(st.nextToken());
					}
				}
				
				arr[index] = new Node(data, left, right);
			}
			
			stack = new int[N];
			top = -1;
			
			dfs(1);
			
			System.out.println("#" + t + " " + stack[0]);
		}
	}
	
	static void dfs(int index) {
		if(arr[index].left != -1) {
			dfs(arr[index].left);
		}
		if(arr[index].right != -1) {
			dfs(arr[index].right);
		}
		
		if(arr[index].data.equals("+")) {
			stack[top - 1] += stack[top--];
		} else if(arr[index].data.equals("-")) {
			stack[top - 1] -= stack[top--];
		} else if(arr[index].data.equals("*")) {
			stack[top - 1] *= stack[top--];
		} else if(arr[index].data.equals("/")) {
			stack[top - 1] /= stack[top--];
		} else {
			// 숫자
			stack[++top] = Integer.parseInt(arr[index].data);
		}
	}
	
	static class Node {
		String data;
		int left;
		int right;
		
		public Node(String data, int left, int right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
}
