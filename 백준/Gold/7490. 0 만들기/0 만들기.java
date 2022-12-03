import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N;
    static int END;
    static BufferedWriter bw;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            END = Integer.parseInt(br.readLine());
            dfs("1", 0, 1, 1, 1);
            bw.write("\n");
        }
        bw.close();
    }

    public static void dfs(String str, int sum, int temp, int op, int phase) throws Exception {
        if (phase == END) {
            sum += op * temp;
            if (sum == 0) bw.write(str + "\n");
            return;
        }
        dfs(str + " " + (phase + 1), sum, temp * 10 + phase + 1, op, phase + 1);
        dfs(str + "+" + (phase + 1), sum + op * temp, phase + 1, 1, phase + 1);
        dfs(str + "-" + (phase + 1), sum + op * temp, phase + 1, -1, phase + 1);

    }

}
