package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class SW1218_괄호짝짓기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		Stack<Character> stack = new Stack<Character>();
//		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= 10; t++) {
			int ans = 1;
			int N = Integer.parseInt(br.readLine());
//			char[] arr = new char[N];
			char cur;
			String line = br.readLine();
//			System.out.println(N);
			for(int i = 0; i < N; i++) {
				cur = line.charAt(i);
				if(cur == '(' || cur == '[' || cur == '{' || cur == '<' ) {
					stack.push(cur);
				}
				else if(cur == ')') {
					if(stack.peek() == '(') stack.pop();
					else {
						ans = 0;
						break;
					}
				}
				else if(cur == ']') {
					if(stack.peek() == '[') stack.pop();
					else {
						ans = 0;
						break;
					}
				}
				else if(cur == '}') {
					if(stack.peek() == '{') stack.pop();
					else {
						ans = 0;
						break;
					}
				}
				else if(cur == '>') {
					if(stack.peek() == '<') stack.pop();
					else {
						ans = 0;
						break;
					}
				}
//				System.out.print(i + " " );
			}
//			System.out.println(stack.toString());
			if(!stack.isEmpty()) {
				ans = 0;
				stack.clear();
			}
			
			
			
			System.out.println("#" + t + " " + ans);
		}

	}
}

