import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[3];
		
		for(int i=0;i<3;i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i=0;i<3;i++) {
			for(int j=i+1;j<3;j++) {
				if(num[i] > num[j]) {
					int temp = num[i];
					num[i] = num[j];
					num[j] = temp;
				}
			}
		}
		String template = "%d %d %d";
		System.out.println(String.format(template, num[0], num[1], num[2]));
	}
}
