package swexpert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1231_중위순회 {
	static int N;
	static Node[] arr;
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			N = Integer.parseInt(br.readLine().trim());
			
			arr = new Node[N + 1];
			
			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				int index = Integer.parseInt(st.nextToken());
				char word = st.nextToken().charAt(0);
				
				if(!st.hasMoreTokens()) {
					arr[i] = new Node(index, word);
				} else {
					int left = Integer.parseInt(st.nextToken());
					
					if(!st.hasMoreTokens()) {
						arr[i] = new Node(index, word, left);
					} else {
						int right = Integer.parseInt(st.nextToken());
						arr[i] = new Node(index, word, left, right);
					}
				}
			}
			
			System.out.print("#" + t + " ");
			// 중위순회
			
			dfs(1);
			
			System.out.println();
		}
	}
	
	static void dfs(int index) {
		if(arr[index].left != -1)
			dfs(arr[index].left);
		System.out.print(arr[index].word);
		if(arr[index].right != -1)
			dfs(arr[index].right);
	}
	
	static class Node {
		int index;
		char word;
		int left = -1;
		int right = -1;
		
		public Node(int index, char word) {
			this.index = index;
			this.word = word;
		}

		public Node(int index, char word, int left) {
			this.index = index;
			this.word = word;
			this.left = left;
		}
		
		public Node(int index, char word, int left, int right) {
			this.index = index;
			this.word = word;
			this.left = left;
			this.right = right;
		}
	}
}
