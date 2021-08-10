package com.woorim.problems;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BOJ1158_요세푸스문제 {
	public static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		sc.close();
		Queue<Integer> q = new LinkedList<>();
		Queue<Integer> ans = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		int cnt = 1;
		while(q.size() > 1) {
			if(cnt == K) {
				ans.offer(q.poll());
				cnt = 1;
				continue;
			}
			q.offer(q.poll());
			cnt++;
		}
		

		
		
		System.out.println(ans.size());
		System.out.print("<");
		while(ans.size() > 1) {
			System.out.print(ans.poll()+", ");
		}
		System.out.print(ans.poll());
		System.out.print(">");

	}

}
