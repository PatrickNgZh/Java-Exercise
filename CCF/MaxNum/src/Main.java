//2017-6-3
//�����ţ�	201312-1
//�������ƣ�	���ִ���������
//ʱ�����ƣ�	1.0s
//�ڴ����ƣ�	256.0MB
//����������	
//��������
//��������n�����������ҳ������г��ִ�����������������������ж���������������С��һ����
//�����ʽ
//��������ĵ�һ��ֻ��һ��������n(1 �� n �� 1000)����ʾ���ֵĸ�����
//��������ĵڶ�����n������s1, s2, ��, sn (1 �� si �� 10000, 1 �� i �� n)�����ڵ����ÿո�ָ���
//�����ʽ
//���������n�������г��ִ�����������������������ж�������������С��һ����
//��������
//6
//10 1 10 20 30 20
//�������
//10

import java.util.*;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	public void run() {
		Scanner fin = new Scanner(System.in);
		int N = fin.nextInt();
		int[] count = new int[10001];
		for (int i = 0; i < N; ++i) {
			++count[fin.nextInt()];
		}
		int maxCount = -1;
		int result = 0;
		for (int i = 1; i <= 10000; ++i) {
			if (count[i] > maxCount) {
				maxCount = count[i];
				result = i;
			}
		}
		System.out.println(result);
	}
}
