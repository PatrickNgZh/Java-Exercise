//2017-6-3
//试题编号：	201312-1
//试题名称：	出现次数最多的数
//时间限制：	1.0s
//内存限制：	256.0MB
//问题描述：	
//问题描述
//　　给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。
//输入格式
//　　输入的第一行只有一个正整数n(1 ≤ n ≤ 1000)，表示数字的个数。
//　　输入的第二行有n个整数s1, s2, …, sn (1 ≤ si ≤ 10000, 1 ≤ i ≤ n)。相邻的数用空格分隔。
//输出格式
//　　输出这n个次数中出现次数最多的数。如果这样的数有多个，输出其中最小的一个。
//样例输入
//6
//10 1 10 20 30 20
//样例输出
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
