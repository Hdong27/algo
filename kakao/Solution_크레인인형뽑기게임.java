package kakao;

import java.util.Arrays;

public class Solution_ũ���������̱���� {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] {
			{0,0,0,0,0},
			{0,0,1,0,3},
			{0,2,5,0,1},
			{4,2,4,4,2},
			{3,5,1,3,1},
		}, new int[] {1,5,3,5,1,2,1,4}));
	}
	
	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		int len = board[0].length;
		int limit = board.length;
		int[] location = new int[len];
		
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[j][i] > 0) {
					location[i] = j;
					break;
				}
			}
		}
		
		int[] stack = new int[moves.length];
		int top = -1;
		
		for (int i = 0; i < moves.length; i++) {
			int temp = moves[i] - 1;
			
			if(location[temp] < limit) {	// �ش� ��ġ�� ������ ������
				stack[++top] = board[location[temp]++][temp];
				
				// stack�� ������ ������ ���ش�
				if(top > 0 && stack[top] == stack[top-1]) {
					top -= 2;
					answer += 2;
				}
				
			}
		}
		
		return answer;
	}
}
