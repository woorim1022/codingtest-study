import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int m = 0;
//array를 i번째 부터 j번째 까지 잘라서 cut[]에 저장
        for(int j = 0; j < commands.length; j++){
            int num = commands[j][1] - commands[j][0] + 1;
            int [] cut = new int[num];  //변수로 배열 개수 할당 가능한지 공부하기
            int k = 0;
            //자르고 저장하는 배열 초기화
            for(int n = 0; n < num; n++)
                cut[n] = 0;
            
            for(int i = 0; i < array.length; i++){
                if((i >= commands[j][0]-1) && (i <= commands[j][1]-1))
                    cut[k++] = array[i];
                // System.out.println(Arrays.toString(cut) + k);
            }  
//cut[]를 정렬
           Arrays.sort(cut);
//k번째 원소를 return[]에 저장
            answer[m++] = cut[commands[j][2] - 1];
        }
        return answer;
    }
}