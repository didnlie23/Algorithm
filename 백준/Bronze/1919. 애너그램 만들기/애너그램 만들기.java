import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
    	Scanner sc = new Scanner(System.in);
    	
    	int[][] frequency = new int[2][26];
    	
    	for(int i=0;i<2;i++) {
    		String temp = sc.nextLine();
    		int length = temp.length();
    		for(int j=0;j<length;j++) {
    			frequency[i][temp.charAt(j)-'a']++;
    		}
    	}
    	
    	int answer = 0;
    	for(int i=0;i<26;i++) {
    		answer += Math.abs(frequency[0][i] - frequency[1][i]);
    	}
    	
    	System.out.println(String.valueOf(answer));
    }
}