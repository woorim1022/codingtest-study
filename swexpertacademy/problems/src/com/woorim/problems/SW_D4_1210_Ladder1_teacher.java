package com.woorim.problems;

import java.io.FileInputStream;
import java.util.Scanner;

public class SW_D4_1210_Ladder1_teacher {
	static int N = 100;
	static int[][] map = new int[N][N];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			sc.nextInt(); // 케이스 번호 (프로그램 사용하지 않음)
			// 초기 데이터 입력하기
			for (int x = 0; x < N; x++)
				for (int y = 0; y < N; y++)
					map[x][y] = sc.nextInt();

			// 마지막 줄에서 목표위치 찾기
			int currentY = -1;
			for (int y = 0; y < N; y++) {
				if (map[N - 1][y] == 2) {
					currentY = y;
					break;
				}
			}
			
			// 시작 X의 위치( 목표 위치의 위의 줄부터 시작)
			int currentX = N - 2;
			// 반복을 돌면서 currentX가 0이 되면 종료개념
			while (currentX != 0) {
				if (go(currentX, currentY + 1)) { // 오른쪽에 갈 수 있는지 체크한다.
					currentY += 1;
					while (go(currentX, currentY + 1)) currentY += 1;
				} else if (go(currentX, currentY - 1)) { // 왼쪽에 갈 수 있는지 체크한다.
					currentY -= 1;
					while (go(currentX, currentY - 1)) currentY -= 1;
				}
				// 위의 작업을 하고 빠져나오거나 위의 경우가 없을 경우 x축을 위로 한칸 이동시킨다.
				currentX--;
			}
			System.out.println("#" + t + " " + currentY);
		}
		sc.close();
	}

	static boolean go(int x, int y) {
		return y >= 0 && y < N && map[x][y] == 1;
	}
}
