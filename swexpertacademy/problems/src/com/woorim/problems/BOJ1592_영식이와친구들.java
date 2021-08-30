package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//공을 M번보다 적게 받은 사람이 공을 던질 때, 
//현재 공을 받은 횟수가 홀수번이면 자기의 현재 위치에서 시계 방향으로 L번째 있는 사람에게, 
//짝수번이면 자기의 현재 위치에서 반시계 방향으로 L번째 있는 사람에게 공을 던진다
public class BOJ1592_영식이와친구들 {
	static int N, M, L;
	static int[] people;
	static int answer;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		people = new int[N];

		solve(0);
		
		System.out.println(answer);
	}

	private static void solve(int idx) {
		people[idx]++;
		if(people[idx] == M) return;
		answer++;
		if(people[idx] % 2 == 0) { // 짝수면
			//현재 위치에서 반시계 방향으로 L번째 있는 사람에게
			idx = ((N + (idx-L)) % N);
			solve(idx);
			// 0 0 0 0 0 
			//     i
			// 0 1 2 3 4
		}else { // 홀수면
			//현재 위치에서 시계 방향으로 L번째 있는 사람에게,
			idx = ((idx+L) % N);
			solve(idx);
		}
	}
}
