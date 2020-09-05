package kakao;

public class Solution_파일명정렬 {
	public static void main(String[] args) {
		
	}
	
	public static String[] solution(String[] files) {
		File[] arr = new File[files.length];
		
		for (int i = 0; i < files.length; i++) {
			String temp = files[i];
		}
		return new String[] {};
	}
	
	static class File {
		String name;
		String head;
		int number;
		
		public File(String name, String head, int number) {
			this.name = name;
			this.head = head;
			this.number = number;
		}
	}
}
