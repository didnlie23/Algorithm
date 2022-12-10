import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] treeHeight = new int[N];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            treeHeight[i] = Integer.parseInt(st.nextToken());
            max = Math.max(treeHeight[i], max);
        }

        int left = 0;
        int right = max;
        while (right - left > 1) {
            int middle = (left + right) / 2;
            if (isEnough(treeHeight, middle, M)) {
                left = middle;
            } else {
                right = middle;
            }
        }

        bw.write(String.valueOf(left));
        bw.close();
    }

    public static boolean isEnough(int[] treeHeight, int height, int M) {
        Long sum = 0L;
        for (int i = 0; i < treeHeight.length; i++) {
            int remain = treeHeight[i] - height;
            if (remain > 0) {
                sum += remain;
            }
        }
        return M <= sum;
    }
}