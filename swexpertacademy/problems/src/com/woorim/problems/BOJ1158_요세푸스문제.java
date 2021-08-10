package com.woorim.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158_요세푸스문제 {
	static int N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();

		solve();
	}

	private static void solve() {
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}

		StringBuffer result = new StringBuffer("<");
		int cnt = 1;
		while (q.size() > 1) {
			if (cnt == K) {
				result.append(q.poll() + ", ");
				cnt = 1;
				continue;
			}
			q.offer(q.poll());
			cnt++;
		}
		System.out.print(result.toString() + q.poll() + ">");
	}

}
