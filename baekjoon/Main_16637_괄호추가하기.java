package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_16637_괄호추가하기 {
	static int result;
	private static int len;
	private static int r;
	private static int[] save;
	private static int[] num;
	private static char[] oper;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		num = new int[N/2 + 1];
		oper = new char[N/2];
		
		String s = br.readLine().trim();
		for (int i = 0; i < num.length; i++) {
			num[i] = s.charAt(i * 2) - '0';
		}
		
		for (int i = 0; i < oper.length; i++) {
			oper[i] = s.charAt(i * 2 + 1);
		}
		
		len = oper.length;
		int index = 1;
		result = num[0];
		for (int i = 0; i < len; i++) {
			switch(oper[i]) {
			case '+':
				result += num[index++];
				break;
			case '-':
				result -= num[index++];
				break;
			case '*':
				result *= num[index++];
				break;
			}
		}
		
		for (r = 1; r <= len; r++) {
			save = new int[r];
			Comb(0, 0);
		}
		
		System.out.println(result);
	}
	
	static void Comb(int cnt, int start) {
		if(cnt == r) {
			// 연속되는 놈은 안됨
			if(cnt > 1) {
				for (int i = 0; i < r - 1; i++) {
					if(save[i] + 1 == save[i + 1]) {
						return;
					}
				}
			}
			
			function();
			
			return;
		}
		
		for (int i = start; i < len; i++) {
			save[cnt] = i;
			Comb(cnt + 1, i + 1);
		}
	}
	
	static void function() {
		// save를 이용해서 연산하기
		int[] temp = new int[len];
		boolean[] check = new boolean[len];
		
		for (int i = 0; i < r; i++) {
			check[save[i]] = true;
		}
		
		for (int i = 0; i < len; i++) {
			if(check[i]) {
				switch(oper[i]) {
				case '+':
					temp[i] = num[i] + num[i+1];
					break;
				case '-':
					temp[i] = num[i] - num[i+1];
					break;
				case '*':
					temp[i] = num[i] * num[i+1];
					break;
				}
			}
		}
		
		int max = 0;
		
		if(!check[0]) {
			if(check[1]) {
				switch(oper[0]) {
				case '+':
					max = num[0] + temp[1];
					break;
				case '-':
					max = num[0] - temp[1];
					break;
				case '*':
					max = num[0] * temp[1];
					break;
				}
			} else {
				switch(oper[0]) {
				case '+':
					max = num[0] + num[1];
					break;
				case '-':
					max = num[0] - num[1];
					break;
				case '*':
					max = num[0] * num[1];
					break;
				}
			}
		} else {
			max = temp[0];
		}
		
		for (int i = 1; i < len - 1; i++) {
			if(!check[i]) {
				if(!check[i+1]) {
					switch(oper[i]) {
					case '+':
						max += num[i+1];
						break;
					case '-':
						max -= num[i+1];
						break;
					case '*':
						max *= num[i+1];
						break;
					}
				} else {
					switch(oper[i]) {
					case '+':
						max += temp[i+1];
						break;
					case '-':
						max -= temp[i+1];
						break;
					case '*':
						max *= temp[i+1];
						break;
					}
				}
			}
		}
		
		if(!check[len-1]) {
			switch(oper[len-1]) {
			case '+':
				max += num[len];
				break;
			case '-':
				max -= num[len];
				break;
			case '*':
				max *= num[len];
				break;
			}
		} else {
			
		}
		
		result = max > result ? max : result;
	}
}
