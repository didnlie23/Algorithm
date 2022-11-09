import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] numbers = new int[7];
		for(int i=0;i<3;i++) {
			numbers[sc.nextInt()]++; // 전체 배열에 등장 빈도수 저장
		}
		
		int result = 0;
		for(int i=1;i<7;i++) {
			if (numbers[i] == 3) {			// 모두 숫자가 같은 경우
				result = i * 1000 + 10000;
				break;
			}else if (numbers[i] == 2) {	// 숫자가 2번 등장한 경우
				result = i * 100 + 1000;
				break;
			}else if (numbers[i] == 1) {	// 숫자 6까지 상금 갱신
				result = i * 100;
			}
		}
		System.out.println(result);
		sc.close();
	}
}