package com.woorim.problems;

/**
1954. 달팽이 숫자

달팽이는 1부터 N*N까지의 숫자가 시계방향으로 이루어져 있다.
다음과 같이 정수 N을 입력 받아 N크기의 달팽이를 출력하시오.


[예제]
N이 3일 경우,
N이 4일 경우,


[제약사항]
달팽이의 크기 N은 1 이상 10 이하의 정수이다. (1 ≤ N ≤ 10)


[입력]
가장 첫 줄에는 테스트 케이스의 개수 T가 주어지고, 그 아래로 각 테스트 케이스가 주어진다.
각 테스트 케이스에는 N이 주어진다.


[출력]

각 줄은 '#t'로 시작하고, 다음 줄부터 빈칸을 사이에 두고 달팽이 숫자를 출력한다.
(t는 테스트 케이스의 번호를 의미하며 1부터 시작한다.)

입력
2    
3   
4             
 
출력
#1
1 2 3
8 9 4
7 6 5
#2
1 2 3 4
12 13 14 5
11 16 15 6
10 9 8 7
 */
import java.util.Scanner;

public class SW_D2_1954_달팽이숫자_teacher {
	/*
	 * (0,0)(0,1)(0,2) 
	 * (1,0)(1,1)(1,2) 
	 * (2,0)(2,1)(2,2)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int snail[][] = new int[N][N];
			// 입력숫자,   인덱스조정용(1, -1), x,y좌표, 해당방향이동카운트
			int cnt = 0, change = 1, x = 0, y = -1, k = N;

			while (true) {
				for (int i = 1; i <= k; i++) {
					snail[x][y += change] = ++cnt;	
				}
				if (--k == 0) break;

				for (int i = 1; i <= k; i++) {
					snail[x += change][y] = ++cnt;
				}
				change *= -1;
			}

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j] + " ");
				}	
				System.out.println();
			}
		}
		sc.close();
	}
}