import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            dp[i + 1] = Math.max(dp[i], dp[i + 1]); // 현재 날짜의 일을 안하는 경우와 다음 날의 누적 비교
            if (i + t <= N) {   // 현재 날짜의 일을 할 수 있다면
                dp[i + t] = Math.max(dp[i + t], dp[i] + p);
            }
        }
        bw.write(String.valueOf(dp[N]));
        bw.flush();
        bw.close();
    }
}
