package com.woorim.problems;

//노란색과 갈색으로 색칠된 격자의 개수는 기억했지만, 
//전체 카펫의 크기는 기억하지 못했습니다.
//카펫의 가로, 세로 크기를 순서대로 배열에 담아 return
public class PR42842_카펫 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] answer = solution(10, 2);
		System.out.println(answer[0] + " " + answer[1]);
	}
	
	public static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //yellow = garo * sero
        
        int initSero = 1;
        while(true) {
        	int sero = initSero++;     //1, 2, 3, 4, 5, 6, 7
        	int garo = yellow / sero;  //24,12,8, 6, 4, 4, 3
        	if(garo*sero == yellow) {
        		if(brown == 2*(garo+sero)+4) {
        			answer[0] = garo+2;
        			answer[1] = sero+2;
        			break;
        		}
        	}
        }
        
        return answer;
    }

}