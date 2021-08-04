package com.woorim.problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SW1873_상호의배틀필드 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		StringTokenizer st = null;
		String line = "";
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			char[][] map = new char[H][W];
			int cx = -1, cy = -1;
			for(int i = 0; i < H; i++) {
				line = br.readLine();
				for(int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if(map[i][j] == '>' || 
							map[i][j] == '<' ||
							map[i][j] == '^' ||
							map[i][j] == 'v') {
						cx = i; cy = j;
					}
				}
			}
			int N = Integer.parseInt(br.readLine());
			line = br.readLine();
			char[] move = new char[N];
			for(int i = 0; i < N; i++) {
				move[i] = line.charAt(i);
			}
//			System.out.println(word);
//			System.out.println(Arrays.deepToString(map));
//			System.out.println("--------------------------");
			
			for(int i = 0; i < N; i++) {
				int nx = -1, ny = -1;
				switch(move[i]) {
				case 'U':
					nx = cx-1;
					ny = cy;
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
						map[cx][cy] ='.';
						cx = nx;
						cy = ny;
						map[nx][ny] ='^';
					}
					break;
				case 'D':
					nx = cx+1;
					ny = cy;
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
						map[cx][cy] ='.';
						cx = nx;
						cy = ny;
						map[nx][ny] ='v';
					}
					break;
				case 'L':
					nx = cx;
					ny = cy-1;
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
						map[cx][cy] ='.';
						cx = nx;
						cy = ny;
						map[nx][ny] ='<';
					}
					break;
				case 'R':
					nx = cx;
					ny = cy+1;
					if(nx >= 0 && nx < H && ny >= 0 && ny < W && map[nx][ny] == '.') {
						map[cx][cy] ='.';
						cx = nx;
						cy = ny;
						map[nx][ny] ='>';
					}
					break;
				case 'S':
					switch(map[cx][cy]){
					case '^':
						for(int j = cx-1; j >= 0; j--) {
							if(map[j][cy] == '*') {
								map[j][cy] = '.';
								break;
							}
							else if(map[j][cy] == '#') {
								break;
							}
						}
						break;
					case 'v':
						for(int j = cx+1; j < H; j++) {
							if(map[j][cy] == '*') {
								map[j][cy] = '.';
								break;
							}
							else if(map[j][cy] == '#') {
								break;
							}
						}
						break;
					case '<':
						for(int j = cy-1; j >= 0; j--) {
							if(map[cx][j] == '*') {
								map[cx][j] = '.';
								break;
							}
							else if(map[cx][j] == '#') {
								break;
							}
						}
						break;
					case '>':
						for(int j = cy+1; j < W; j++) {
							if(map[cx][j] == '*') {
								map[cx][j] = '.';
								break;
							}
							else if(map[cx][j] == '#') {
								break;
							}
						}
						break;
					}
					break;
				}
			}
			
			System.out.print("#" + t + " ");
			for(int i = 0; i < H ; i++) {
				for(int j = 0; j < W ; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}

	
}
