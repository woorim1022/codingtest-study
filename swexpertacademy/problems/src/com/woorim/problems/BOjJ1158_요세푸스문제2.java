package com.woorim.problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOjJ1158_요세푸스문제2 {
	static int N, K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] data = br.readLine().split(" ");
		N = Integer.parseInt(data[0]);
		K = Integer.parseInt(data[1]) - 1;
		solve();

	}
	
	private static void solve() {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i = 1;i <= N; i++) {
			list.add(i);
		}
		
		StringBuffer result = new StringBuffer("<");
		int idx = 0;
		while(list.size() > 1){
			idx = (idx + K) % list.size(); // 제거할 인덱스
			result.append(list.remove(idx) + ", ");
		}
		System.out.print(result.toString() + list.remove(0) + ">");
		
		
	}

}
