package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
//1m2의 넓이에 자라는 참외의 개수는 헤아렸고, 이제 참외밭의 넓이만 구하면 된다. 
//참외밭은 ㄱ-자 모양이거나 ㄱ-자를
//90도, 180도, 270도 회전한 모양(┏, ┗, ┛ 모양)의 육각형이다. 
//다행히도 밭의 경계(육각형의 변)는 모두 동서 방향이거나 남북 방향이었다.
//동쪽은 1, 서쪽은 2, 남쪽은 3, 북쪽은 4
public class BOJ2477_참외밭 {
	public static class Side{
		int dir, len;
		public Side(int dir, int len) {
			this.dir = dir;
			this.len = len;
		}
		@Override
		public String toString() {
			return "Side [dir=" + dir + ", len=" + len + "]";
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		Side[] sides = new Side[6];
		for(int i = 0 ; i < 6; i++) {
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			sides[i] = new Side(dir, len);
		}
		//자신의 전의 면의 방향과 다음 면의 방향이 다르면 작은 사각형에 해당
		//큰 사각형의 넓이 - 작은 사각형의 넓이
		int lW = 0, lH = 0, sW = 0, sH = 0;
		for(int i = 0 ; i < 6; i++) {
			int pre = (i==0)?5:i-1;
			int next = (i==5)?0:i+1;
			if(sides[pre].dir == sides[next].dir) {
				if(sides[i].dir == 3 || sides[i].dir == 4) {
					sW = sides[i].len;
				}else {
					sH = sides[i].len;
				}
				continue;
			}
			// 남이나 북이고 (dir = 3 or 4) && len < lW이면 
			if(sides[i].len > lW && (sides[i].dir == 3 || sides[i].dir == 4)) {
				lW = sides[i].len;
				continue;
			}
			// 동이나 서이고 (dir = 1 or 2) && len < lH이면 
			if(sides[i].len > lH && (sides[i].dir == 1 || sides[i].dir == 2)){
				lH = sides[i].len;
				continue;
			}
		}
		System.out.println(((lW*lH)-(sW*sH))*K);
		
	}
}


