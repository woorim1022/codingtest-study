import java.util.Arrays;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
			String temp = "";

			Arrays.sort(participant);
			Arrays.sort(completion);
			
			for(int i = 0; i < completion.length; i++) {
				if(!participant[i].equals(completion[i])) {
					temp += participant[i];
					break;
				}
				else {
					continue;
				}
			}
			
			if(!temp.equals("")) {
				answer = temp;
			}
			else {
				answer = participant[completion.length];
			}
			
	        return answer;
    }
}