package com.woorim.problems;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SW1225_암호생성기 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("C:\\Users\\USER\\Desktop\\TIL\\aaa.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String [] tokens = null;
		int[] numbers = new int[8];
		Queue<Integer> q = new LinkedList<>();
		for (int t = 1; t <= 10; t++) {
			br.readLine();	// 테스트케이스번호 : 사용 안함
			tokens = br.readLine().split(" ");	// 공백 단위로 문자열을 파싱
			
			int min = Integer.MAX_VALUE;
			for(int i = 0; i < 8; i++) {
				numbers[i] = Integer.parseInt(tokens[i]);
				min = Math.min(min, numbers[i]); // 반복문이 끝나면 8개 중 가장 작은 값이 들어온다
			}
			
			// 공통으로 차감할 수 있는 최대 숫자 v 구하기
			int v = min / 15 * 15;
			// v == min 이 같은 경우 -15 한다.
			if(v != 0 && min == v) v -= 15;
			
//			System.out.println(v);
			q.clear();
			for(int i = 0; i < 8; i++) {
				q.add(numbers[i] - v);
			}
//			System.out.println(Arrays.toString(numbers));
//			System.out.println(q);
			
			int minus = 1, tmp = 0;
			while(true) {
				tmp = q.poll() - minus;
				if(tmp <= 0) {
					q.offer(0);
					break;
				}
				q.offer(tmp);
				
				minus = minus % 5 + 1;
			}
			System.out.print("#" + t + " ");
			while (!q.isEmpty()) {
				System.out.print(q.poll() + " ");
			}
			System.out.println();
		}

	}

}



//1 ~ 5 한 사이클
//총 8개의 숫자
//
// 2자리수
// 1 2
// 3 4 
// 5 1
// 2 3 
// 4 5
// 1 2
// ....
//==> 2 사이클 만에 15만큼 빠짐

// 3 자리수
// 1 2 3
// 4 5 1
// 2 3 4
// 5 1 2
// 3 4 5
// ....
// ==> 3 사이클 만에 15만큼 빠짐

// . . .
// ==> 8자리면 8 사이클 만에 15만큼 빠짐

// 20 21 16 17 19 30 32 31
// 15 15 15 15 15 15 15 15  _
//-----------------------------
//  5  6  1  2  4 15 17 16