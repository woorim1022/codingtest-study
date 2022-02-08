package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//1번 컴퓨터를 통해 웜 바이러스에 걸리게 되는 컴퓨터의 수를 출력하는 프로그램을 작성하시오.

public class BOJ2606_바이러스 {
	static int cNum, pNum;
	static int[][] map;
	static boolean[] visit;
	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		cNum = Integer.parseInt(br.readLine());
		pNum = Integer.parseInt(br.readLine());
		answer = 0;
		map = new int[cNum + 1][cNum + 1];
		visit = new boolean[cNum + 1];

		for (int i = 0; i < pNum; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r][c] = 1;
			map[c][r] = 1;
		}

		solve(1);

		System.out.println(answer - 1);
	}

	private static void solve(int cur) {
		if (visit[cur])
			return;
		visit[cur] = true;
		answer++;
		for (int i = 0; i < map.length; i++) {
			if (map[cur][i] == 1 && !visit[i]) {
				solve(i);
			}

		}

	}
}
