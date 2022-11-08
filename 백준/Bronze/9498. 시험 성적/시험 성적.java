import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		char answer;
		if (num >= 90)
			answer = 'A';
		else if (num >= 80)
			answer = 'B';
		else if (num >= 70)
			answer = 'C';
		else if (num >= 60)
			answer = 'D';
		else
			answer = 'F';
		
		System.out.println(answer);
	}
}