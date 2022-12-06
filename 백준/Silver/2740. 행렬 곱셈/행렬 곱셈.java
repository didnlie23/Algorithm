import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrixA = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        st.nextToken();
        int K = Integer.parseInt(st.nextToken());
        int[][] matrixB = new int[M][K];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] matrixC = new int[N][K];
        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                for (int m = 0; m < M; m++) {
                    matrixC[n][k] += matrixA[n][m] * matrixB[m][k];
                }
            }
        }
        for (int n = 0; n < N; n++) {
            for (int k = 0; k < K; k++) {
                bw.write(matrixC[n][k] + " ");
            }
            bw.write("\n");
        }
        bw.close();
    }
}