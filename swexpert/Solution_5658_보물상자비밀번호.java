package swexpert;
import java.io.BufferedReader;import java.io.InputStreamReader;import java.util.ArrayList;import java.util.Collections;import java.util.Comparator;import java.util.HashSet;import java.util.List;import java.util.Set;import java.util.StringTokenizer;

public class Solution_5658_�������ں�й�ȣ {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int limit = N / 4;			
			int[] num = new int[N];			String s = br.readLine().trim();			for (int i = 0; i < N; i++) {				num[i] = s.charAt(i) - '0';				if(num[i] > 10) {					num[i] -= 7;				}			}						Set<Integer> hs = new HashSet<>();			List<Integer> list = new ArrayList<>();						// �ε����� ����� �۾��� �����ϰ� ���ڸ� ���Ѵ�.			for (int i = 0; i <= N - limit; i++) {				// i ~ N / 4 + i				int su = 0;				int pow = limit - 1;				for (int j = i; j < limit + i; j++) {					su += num[j] * Math.pow(16, pow--);				}				if(hs.add(su)) {					list.add(su);				}			}						// �ڿ� ���� ���ڸ� ���� �迭�� �����Ѵ�.			int[] temp = new int[2 * (limit - 1)];			int index = 0;			for (int i = N - limit + 1; i < N; i++) {				temp[index++] = num[i];			}			for (int i = 0; i < limit - 1; i++) {				temp[index++] = num[i];			}									// ���			for (int i = 0; i <= temp.length - limit; i++) {				int su = 0;				int pow = limit - 1;				for (int j = i; j < limit + i; j++) {					su += temp[j] * Math.pow(16, pow--);				}				if(hs.add(su)) {					list.add(su);				}			}						Collections.sort(list, new Comparator<Integer>() {				@Override				public int compare(Integer o1, Integer o2) {					return o2 - o1;				}			});						System.out.println("#" + t + " " + list.get(K - 1));		}
	}
}
