//시간초과가 되는 테케가 생기는 코드.
//number의 자리수가 1부터 1,000,000사이이기 때문에 이중 for문을 사용하면 안되는것 같다.

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        //탐색을 확인할 위치 인덱스
        int index = 0;
        
        //number 문자열 길이에서 k 만큼 뺀 만큼 for문 반복(answer의 길이 만큼 반복)
        for(int j = 0; j < number.length() - k; j++){
            char max = '0';
            
            //탐색을 시작할 위치부터 뒤에 남아야 하는 자리수 개수(??)의 앞자리까지 탐색시작
            for(int i = index; i <= k + j; i++){
                if(number.charAt(i) > max){
                    max = number.charAt(i);
                    index = i+1;
                }
            }
            answer += max;
        }
        return answer;
    }
}