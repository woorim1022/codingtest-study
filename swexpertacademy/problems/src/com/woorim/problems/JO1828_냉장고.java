package com.woorim.problems;
/*
N개의 화학 물질 C1, C2, …, Cn이 있다. 
Ci는 온도 xi이상, yi이하의 온도에서 보관되어야만 안전하다.
이 화학 물질들을 모두 보관하기 위해서는 여러 대의 냉장고가 필요한데 
가능하면 적은 수의 냉장고를 사용하고 싶다. 
*/
//보관온도는 -270° ~ 10000°
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JO1828_냉장고 {
	static class Chem implements Comparable<Chem>{
		int low, high;
		public Chem(int low, int high) {
			super();
			this.low = low;
			this.high = high;
		}
		@Override
		public int compareTo(Chem o) {
			int value = this.high - o.high;
			return value;
			
		}
	}
	static int[][] temp;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Chem[] chemicals = new Chem[N];
		for(int i = 0;i < N;i++) {
			chemicals[i] = new Chem(sc.nextInt(), sc.nextInt());
		}
		System.out.println(getRefNum(chemicals));
	}
	static int getRefNum(Chem[] chemicals){
		int cnt = 1;
		Arrays.sort(chemicals);	// 최고온도 기준으로 오름차순 정렬
		int max = chemicals[0].high; // 가장 낮은 최고온도 max로 설정
		for(int i = 1; i < chemicals.length; i++) {
			if(chemicals[i].low > max) { //현재 화학물질의 최저온도가 max보다 크면
				max = chemicals[i].high; // 현재 화학물질의 최고온도를 새로운 max로 지정
				cnt++; // 냉장고 수 증가
			}
		}
		
		return cnt;
	}



}
