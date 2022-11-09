import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] num = new int[3];
		for (int i = 0; i < 3; i++) {
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		if (num[2] == num[1] && num[1] == num[0]) {
			System.out.println(String.valueOf(10000 + num[2] * 1000));
		} else if (num[2] == num[1]) {
			System.out.println(String.valueOf(1000 + num[2] * 100));
		} else if (num[1] == num[0]) {
			System.out.println(String.valueOf(1000 + num[1] * 100));
		} else {
			System.out.println(String.valueOf(100 * num[2]));
		}
	}
}