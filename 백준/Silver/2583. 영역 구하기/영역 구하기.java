import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] map = new boolean[N][M];
        int K = Integer.parseInt(st.nextToken());
        for(int i=0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int startN = Integer.parseInt(st.nextToken());
            int startM = Integer.parseInt(st.nextToken());
            int endN = Integer.parseInt(st.nextToken());
            int endM = Integer.parseInt(st.nextToken());
            for(int j=startN;j<endN;j++){
                for(int k=startM;k<endM;k++){
                    map[j][k] = true;
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1 ,1};
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if (!map[i][j]){
                    int count = 0;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    map[i][j] = true;
                    while(!queue.isEmpty()){
                        int[] temp = queue.poll();
                        count++;
                        for(int k=0;k<4;k++){
                            int nr = temp[0] + dr[k];
                            int nc = temp[1] + dc[k];
                            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !map[nr][nc]){
                                queue.offer(new int[]{nr, nc});
                                map[nr][nc] = true;
                            }
                        }
                    }
                    answer++;
                    pq.offer(count);
                }
            }
        }
        bw.write(answer+"\n");
        for(int i=0,length=pq.size();i<length;i++){
            bw.write(pq.poll()+" ");
        }
        bw.flush();
        bw.close();
    }
}