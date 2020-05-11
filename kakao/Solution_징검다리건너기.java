package kakao;

public class Solution_징검다리건너기 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3));
	}
	
	public static int solution(int[] stones, int k) {
		int answer = 0;
		
		while(true) {
			// 다리를 건넌다.
			for (int i = 0; i < stones.length; i++) {
				if(stones[i] > 0) {
					stones[i]--;
				} else {
					boolean flag = false;
					for (int j = i + 1; j < i + k; j++) {
						if(j >= stones.length) {
							flag = true;
							break;
						} else if(stones[j] > 0) {
							flag = true;
							stones[j]--;
							i = j;
							break;
						}
					}
					
					if(!flag) {
						return answer;
					}
				}
			}
			answer++;
		}
		
	}
}
