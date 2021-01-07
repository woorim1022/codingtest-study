import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


class Solution {
    public int[] solution(int[] answers) {
       int[] st1 = {1, 2, 3, 4, 5};
		int[] st2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] st3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		//수포자 3명이 맞춘 문제의 개수를 카운트할 리스트 선언
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//수포자들이 맞춘 문제의 갯수는 초기값 0으로 설정
		for(int i = 0; i < 3; i++) list.add(0);
		
		//모듈로 연산을 이용하여 각 문제의 답과 수포자들의 배열 값을 하나씩 받아와 비교하고 
		//맞은 것이 있다면 해당 수포자 리스트에 값을 +1 해줌
		for(int i = 0; i < answers.length; i++) {
			if(answers[i] == st1[i%5]) list.set(0, list.get(0)+1);
			if(answers[i] == st2[i%8]) list.set(1, list.get(1)+1);
			if(answers[i] == st3[i%10]) list.set(2, list.get(2)+1);
		}
		//수포자들이 맞춘 문제 갯수에서 최대 값을 max 변수로 가져옴
		int max = Collections.max(list);
		
		//최고점과 그 동점이 존재하는 사람을 담을 리스트를 만듬
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		
		//수포자의 맞춘 문제 수가 최고 갯수와 같은지 비교하고 맞으면 
		//i+1인덱스 값을 넣어줌.(학생 번호가 1부터 시작하므로)
		for(int i = 0; i < 3; i++) {
			if(list.get(i)==max) list2.add(i+1);
		}
		//최고점과 그 동점자들의 리스트 사이즈만큼을 배열의 길이로 선언
		int[] answer = new int[list2.size()];
		//리스트에 값을 하나씩 배열에 담음 
		for(int i = 0; i < list2.size(); i++) {
			answer[i] = list2.get(i);
		}
        System.out.println(Arrays.toString(answer));
		return answer;
    }
}