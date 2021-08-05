package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ2493_탑 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<Integer> stack = new Stack<Integer>();
		int N = Integer.parseInt(br.readLine());
		int[] tops = new int[N];
		int[] ans = new int[N];
		boolean[] height = new boolean[100000001];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			tops[i] = Integer.parseInt(st.nextToken());
		}
		
		stack.push(0);
		for(int i = 1; i < N; i++) {
			if(tops[stack.peek()] > tops[i]) {
				ans[i] = stack.peek()+1;
			}
			else {
				while(!stack.isEmpty() && tops[stack.peek()] < tops[i]) {
					stack.pop();
				}
				if(!stack.isEmpty()) {
					ans[i] = stack.peek() + 1;
				}
			}
			stack.push(i);
		}
		
		
		for(int i = 0; i < N; i++) {
			System.out.print(ans[i] + " ");
		}
		
		
		
		
	}

}
