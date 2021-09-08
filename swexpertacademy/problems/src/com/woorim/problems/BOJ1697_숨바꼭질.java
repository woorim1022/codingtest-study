//다익스트라 알고리즘
package com.woorim.problems;

import java.util.Scanner;

public class BOJ1697_숨바꼭질 {
	static int N, K;
	static int answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		dijkstra(시작정점, 인접행렬, 시작정점에서의 거리);
		
		System.out.println(answer);
	}

	private static void dijkstra(int start, int ) {
		
	}
}
