import java.io.IOException;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int all_milk = sc.nextInt();
		int[] shop = new int[all_milk];
		for(int i = 0; i < all_milk; i++) {
			shop[i] = sc.nextInt();
        }
		System.out.println(solution(all_milk, shop));
	}
	
	public static int solution(int all_milk, int[] shop) {
		    int answer = 0;
		    int[] rule = {0, 1, 2, 0};
		    int j = 0;
		    for(int i = 0 ; i < all_milk; i++) {
		    	if(rule[j++%3] == shop[i])
		    		answer++;
		    	else 
		    		--j;
		    }
			
	        return answer;
	 }
}
