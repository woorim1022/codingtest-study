package com.woorim.problems;

import java.util.Arrays;
import java.util.Scanner;


public class BOJ1244_스위치켜고끄기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		int[] swch = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//		System.out.println(Arrays.toString(swch));
		int stuN = sc.nextInt();
		sc.nextLine();
		for(int i = 0; i < stuN; i++) {
			int[] stu = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//			stu[0] => 성별 , stu[1] => 받은 수
//			System.out.println(Arrays.toString(stu));
			if(stu[0] == 1) {	// 남자일때
				int temp = stu[1];
				while(temp <= N) {
					swch[temp-1] = (swch[temp-1] - 1) * -1;
					temp += stu[1];
				}
			}
			else if(stu[0] ==2) {	// 여자일 때
				int temp = stu[1];
				swch[temp-1] = (swch[temp-1] - 1) * -1;
				int left = stu[1] - 1;
				int right = stu[1] + 1;
				while(left >= 1 && right <= N) {
					if(swch[left-1] == swch[right-1]) {
						swch[left-1] = (swch[left-1] - 1) * -1;
						swch[right-1] = (swch[right-1] - 1) * -1;
						left--;
						right++;
					}
					else break;
				}
			}
		}
		int p = 0;
		outer:
		while(true){
			for(int i = 0; i < 20; i++) {
				System.out.print(swch[p++] + " ");
				if(p >= swch.length) break outer;
			}
			System.out.println();
		}
		
	}	

}
