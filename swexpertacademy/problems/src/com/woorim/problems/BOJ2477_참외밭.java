package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
//1m2의 넓이에 자라는 참외의 개수는 헤아렸고, 이제 참외밭의 넓이만 구하면 된다. 
//참외밭은 ㄱ-자 모양이거나 ㄱ-자를
//90도, 180도, 270도 회전한 모양(┏, ┗, ┛ 모양)의 육각형이다. 
//다행히도 밭의 경계(육각형의 변)는 모두 동서 방향이거나 남북 방향이었다.
//동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
public class BOJ2477_참외밭 {
	static int K;
	static class Line{
		int dir, length;
		public Line(int dir, int length) {
			this.dir = dir;
			this.length = length;
		}		
	}
	static Line[] lineList = new Line[6];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		int largeSquareWidth = 0;
		int largeSquareHeight = 0;
		int smallSquareWidth = 501;
		int smallSquareHeight = 501;
		for(int i = 0 ; i < 6; i ++) {
			st = new StringTokenizer(br.readLine());
			lineList[i] = new Line(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			if(lineList[i].dir == 3 || lineList[i].dir == 4) { // height
				if(lineList[i].length > largeSquareHeight) {
					largeSquareHeight = lineList[i].length;
				}
				if(i != 0) {
					if(lineList[i-1].length == largeSquareHeight) {					
						smallSquareWidth= largeSquareWidth - lineList[i].length;
					}
					else {					
						smallSquareWidth= lineList[i].length;
					}
				}
			}else {		// width
				if(lineList[i].length > largeSquareWidth) {
					largeSquareWidth = lineList[i].length;
				}
				if(i != 0) {
					if(lineList[i-1].length == largeSquareWidth) {					
						largeSquareHeight= largeSquareHeight - lineList[i].length;
					}
					else {					
						largeSquareHeight= lineList[i].length;
					}
				}
			}
		}
//		
		System.out.println(largeSquareHeight);
		System.out.println(smallSquareHeight);
		System.out.println(largeSquareWidth);
		System.out.println(smallSquareWidth);
		int width = (largeSquareHeight * largeSquareWidth) - (smallSquareHeight * smallSquareWidth);
		System.out.println(width);
		System.out.println(width*K);

	}

}
