package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16235_��������ũ {
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// ���� ũ�� N*N
		int M = Integer.parseInt(st.nextToken());	// ó���� ���� ������ ����
		int K = Integer.parseInt(st.nextToken());	// K�� ���� ����
		
		int[][] map = new int[N+1][N+1];	// ��ü ���� ����
		int[][] tempArr = new int[N+1][N+1];	// �ܿ￡ �߰��ϴ� ����� ��
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				tempArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				map[i][j] = 5;
			}
		}
		
		List<Tree> list = new ArrayList<>();	// ����ִ� ������ ������
		List<Tree> delList = new ArrayList<>();	// ���� �װ� ������ ������� ���� ������ ������
		PriorityQueue<Tree> q = new PriorityQueue<>();	// ����� ���� ���� ������ ����
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			q.add(new Tree(Integer.parseInt(st.nextToken()),
					 Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < K; i++) {	// K�� �ݺ��Ѵ�.
			// ��
			// ������ �ڽ��� ���̸�ŭ ����� �Դ´�.
			// ������ ���̰� 1�����Ѵ�.
			// ���̰� � �������� ����� �Դ´�.
			// ����� �����ϸ� �� ������ �״´�.
			while(!q.isEmpty()) {
				Tree tree = q.poll();
				if(map[tree.x][tree.y] >= tree.age) {	// ������ ���� �� �ִ� ����� �ִ�.
					map[tree.x][tree.y] -= tree.age++;
					list.add(tree);
				} else {	// �׾�� �ϴ� �����̴�.
					delList.add(tree);
				}
			}
			
			// ����Ʈ�� �ִ� �������� �ٽ� ť�� �ֱ�
			for (Tree tree : list) {
				q.add(tree);
			}
			
			// ����
			// ���� ������ ����� �ȴ�.
			// ���� ���� ������ ������ 2��ŭ ����� �þ��.
			for (Tree tree : delList) {
				map[tree.x][tree.y] += tree.age / 2;
			}
			delList.clear();
			
			// ����
			// ������ ������ �Ѵ�.
			// ���̰� 5�� ����� ������ ������ �Ѵ�.
			// ������ 8ĭ�� ���̰� 1�� ������ �����.
			// �ε����� ����� ĭ���� ������ ������ �ʴ´�.
			int size = list.size();
			for (Tree tree : list) {
				if(tree.age % 5 == 0) {	// ������ ������ �� �� �ִ�.
					for (int k = 0; k < 8; k++) {
						int x = tree.x + dx[k];
						int y = tree.y + dy[k];
						
						if(x > 0 && y > 0 && x <= N && y <= N) {	// ���� ����� �ʴ´ٸ� �����Ѵ�.
							q.add(new Tree(x, y, 1));
						}
					}
				}
			}
			list.clear();
			
			
			// �ܿ�
			// �κ��� ����� �߰��Ѵ�.
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					map[j][k] += tempArr[j][k];
				}
			}
		}
		
		System.out.println(q.size());
	}
	
	static class Tree implements Comparable<Tree>{
		int x;	// x��ǥ
		int y;	// y��ǥ
		int age;	// ������ ����
		
		public Tree(int x, int y, int age) {
			this.x = x;
			this.y = y;
			this.age = age;
		}

		@Override
		public int compareTo(Tree o) {
			return this.age - o.age;
		}
	}
}
