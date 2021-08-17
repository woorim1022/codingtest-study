package com.woorim.problems;

import java.util.Scanner;

// 방문순서
// 1 2
// 3 4
//N이 주어졌을 때, r행 c열을 몇 번째로 방문했는지 출력한다.
public class Z {
	static int N, r, c;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		r = sc.nextInt();
		c = sc.nextInt();
		
		//z모양은 가로, 세로가 각각 2^N / 2 개 만큼 생김
		solve();
	}
	
	static void solve() {
		
	}
}
