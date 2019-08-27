package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_2839_������� {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine().trim());
		
		int result = Integer.MAX_VALUE;
		
		for (int i = 0; i <= N / 5; i++) {
			// i = 5kg�� ���� ����
			int count = i;
			int temp = N - i * 5;	// ���� kg��
			if(temp % 3 == 0) {	// ��� ���� �� ������
				count += temp / 3;
				result = result > count ? count : result;
			}
		}
		
		System.out.println(result == Integer.MAX_VALUE ? -1 : result);
	}
}
