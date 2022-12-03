import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];
        int answer = 0;
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[i]);
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if (i + t <= N) { // 일하는 것이 가능하다면
                int sum = dp[i] + p;
                if (dp[i + t] < sum) {
                    dp[i + t] = sum;
                }
            }
            if (i + 1 <= N && dp[i + 1] < dp[i]) {
                dp[i + 1] = dp[i];
            }
        }
        answer = Math.max(answer, dp[N]);
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
