package com.woorim.problems;
/*
 후위 표기식으로 바꾸기 위해서는 스택을 이용한다.
주어진 계산식을 한 글자씩 읽어들일 때, 숫자일 경우 그대로 출력하고, '+' 또는 '*' 기호일 경우 우선 순위에 따라 스택에 담거나 출력한다.
즉, 아래와 같은 조건과 과정을 따른다.
입력을 한 문자씩 읽을 때,
1) 숫자일 경우는 바로 출력
2) '+', '*'기호일 경우, 스택이 비었는지 확인
   2-1) 스택이 비었을 경우, push
   2-2) 스택이 차 있을 경우 ('*'기호가 '+'기호보다 우선순위가 높다)
       2-2-a) 읽어들인 입력이 스택의 top에 있는 값보다 우선순위가 높을 경우 push
       2-2-b) 읽어들인 입력의 스택의 top에 있는 값보다 우선순위가 낮거나 같은 경우 스택의 값을 pop한 뒤 입력을 push
3) 입력을 끝까지 읽었을 때, 스택에 들어있는 내용을 모두 출력
[2. 후위표기식으로 표현된 식을 계산하는 것]
후위표기식을 계산하는 방법 또한 스택을 이용한다. 1의 과정에서 출력내용을 문자열에 담았을 때, 한 문자씩 읽어들인다.
읽어들인 문자가 숫자일 경우 스택에 담고, '+' 또는 '*" 기호일 경우 스택에 담긴 두 숫자를 뽑아 더하거나 곱해 다시 스택에 담는다.
즉, 아래와 같은 조건과 과정을 따른다.
입력을 한 문자씩 읽을 때,
1) 숫자일 경우 스택에 push
2) '+'기호일 경우 pop으로 스택에 담겨진 두 개의 숫자를 뽑아 덧셈하고 이 결과를 다시 스택에 push
3) '*'기호일 경우 pop으로 스택에 담겨진 두 개의 숫자를 뽑아 곱셈하고 이 결과를 다시 스택에 push
4) 입력을 끝까지 읽었을 때, 스택에 들어있는 결과를 출력*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SW1223_계산기2 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t <= 10; t++) {
			int length  = Integer.parseInt(br.readLine());
			char[] tc = br.readLine().toCharArray();
			Stack<Character> op = new Stack<>();
			StringBuffer sb = new StringBuffer();
			/////////////////////// 후위표기식 만들기////////////////////////
			for(int i = 0; i < tc.length; i++) {
				char c = tc[i];
				// 숫자면 그냥 출력한다
				if(c - '0' >= 0 && c - '0' <= 9) {
					sb.append(c);
				}
				else {
					if(op.isEmpty()) {	// 스택이 비어있으면
						op.push(c);
					}
					else {	// 비어있지 않으면
						if(get_prior(op.peek()) <= get_prior(c)) {	// top의 값이 입력값보다 우선순위가 낮으면
							sb.append(op.pop());	// 스택의 top값을 출력
							op.push(c);	// 입력값을 push
						}
						else {	// top값이 입력값보다 우선순위가 높으면 
							op.push(c);	// 입력값을  push
						}
					}
				}
			}
			while(!op.isEmpty()) {	// 스택에 남아있는 연산자를 순서대로 pop해서 출력
				sb.append(op.pop());
			}
			//////////////////////후위표기식 계산하기/////////////////////
			Stack <Integer> nums = new Stack<>();
			for(int i = 0; i < sb.length(); i++) {
				char c = sb.charAt(i);
				if(c - '0' >= 0 && c -'9' <= 0) nums.push(c - '0');
				else {
					int tmp1 = nums.pop();
					int tmp2 = nums.pop();
					if(c == '*') nums.push(tmp1 * tmp2);
					else if(c == '+') nums.push(tmp1 + tmp2);
				}
			}
			
			System.out.println("#" + t + " " + nums.pop());
		}

	}
	
	public static int get_prior(char op) {
		if(op == '*')
			return 1;
		else if(op == '+')
			return 3;
		else
			return -1;
	}

}
