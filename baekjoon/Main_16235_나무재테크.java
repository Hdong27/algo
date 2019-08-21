package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_16235_나무재테크 {
	static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());	// 맵의 크기 N*N
		int M = Integer.parseInt(st.nextToken());	// 처음에 심은 나무의 개수
		int K = Integer.parseInt(st.nextToken());	// K년 동안 진행
		
		int[][] map = new int[N+1][N+1];	// 전체 맵의 정보
		int[][] tempArr = new int[N+1][N+1];	// 겨울에 추가하는 양분의 양
		
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
		
		List<Tree> list = new ArrayList<>();	// 살아있는 나무의 정보들
		List<Tree> delList = new ArrayList<>();	// 봄에 죽고 여름에 양분으로 변할 나무의 정보들
		PriorityQueue<Tree> q = new PriorityQueue<>();	// 양분을 먹일 떄의 나무의 정보
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			q.add(new Tree(Integer.parseInt(st.nextToken()),
					 Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		
		for (int i = 0; i < K; i++) {	// K년 반복한다.
			// 봄
			// 나무가 자신의 나이만큼 양분을 먹는다.
			// 나무의 나이가 1증가한다.
			// 나이가 어린 나무부터 양분을 먹는다.
			// 양분이 부족하면 그 나무는 죽는다.
			while(!q.isEmpty()) {
				Tree tree = q.poll();
				if(map[tree.x][tree.y] >= tree.age) {	// 나무가 먹을 수 있는 양분이 있다.
					map[tree.x][tree.y] -= tree.age++;
					list.add(tree);
				} else {	// 죽어야 하는 나무이다.
					delList.add(tree);
				}
			}
			
			// 리스트에 있는 나무들을 다시 큐에 넣기
			for (Tree tree : list) {
				q.add(tree);
			}
			
			// 여름
			// 죽은 나무가 양분이 된다.
			// 죽은 나무 나이의 나누기 2만큼 양분이 늘어난다.
			for (Tree tree : delList) {
				map[tree.x][tree.y] += tree.age / 2;
			}
			delList.clear();
			
			// 가을
			// 나무가 번식을 한다.
			// 나이가 5의 배수인 나무가 번식을 한다.
			// 인접한 8칸에 나이가 1인 나무가 생긴다.
			// 인덱스를 벗어나는 칸에는 나무가 생기지 않는다.
			int size = list.size();
			for (Tree tree : list) {
				if(tree.age % 5 == 0) {	// 나무는 번식을 할 수 있다.
					for (int k = 0; k < 8; k++) {
						int x = tree.x + dx[k];
						int y = tree.y + dy[k];
						
						if(x > 0 && y > 0 && x <= N && y <= N) {	// 맵을 벗어나지 않는다면 번식한다.
							q.add(new Tree(x, y, 1));
						}
					}
				}
			}
			list.clear();
			
			
			// 겨울
			// 로봇이 양분을 추가한다.
			for (int j = 1; j <= N; j++) {
				for (int k = 1; k <= N; k++) {
					map[j][k] += tempArr[j][k];
				}
			}
		}
		
		System.out.println(q.size());
	}
	
	static class Tree implements Comparable<Tree>{
		int x;	// x좌표
		int y;	// y좌표
		int age;	// 나무의 나이
		
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
