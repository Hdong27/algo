package kakao2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_¿ÀÇÂÃ¤ÆÃ¹æ {
	public static void main(String[] args) {
		String[] s = {
				"Enter uid1234 Muzi", 
				"Enter uid4567 Prodo",
				"Leave uid1234",
				"Enter uid1234 Prodo",
				"Change uid4567 Ryan"	
		};
		
		System.out.println(Arrays.toString(solution(s)));
	}

	public static String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>();
		List<User> list = new ArrayList<>();
		
		for (int i = 0; i < record.length; i++) {
			StringTokenizer st = new StringTokenizer(record[i], " ");
			String action = st.nextToken();
			
			if(action.equals("Enter")) {
				String id = st.nextToken();
				String name = st.nextToken();
				map.put(id, name);
				list.add(new User(id, action));
			} else if(action.equals("Leave")) {
				String id = st.nextToken();
				list.add(new User(id, action));
			} else {	// Change
				String id = st.nextToken();
				String name = st.nextToken();
				map.put(id, name);
			}
		}
		
		String[] answer = new String[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = map.get(list.get(i).id) + (list.get(i).action.equals("Enter") ? "´ÔÀÌ µé¾î¿Ô½À´Ï´Ù." : "´ÔÀÌ ³ª°¬½À´Ï´Ù.");
		}
		return answer;
	}
	
	static class User{
		String id;
		String action;
		
		public User(String id, String action) {
			this.id = id;
			this.action = action;
		}
	}
}
