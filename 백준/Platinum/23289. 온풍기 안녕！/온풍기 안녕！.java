import java.util.*;
import java.io.*;

public class Main {

    static int R;
    static int C;
    static int K;
    static int W;
    static int[][] block;
    static int[][] map;
    static boolean[][] visited;
    static int[][] changed;
    static int targets_size;
    static int nodes_size;
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static ArrayList<int[]> targets;
    static ArrayList<Node> nodes;
    static int chocolate = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        targets = new ArrayList<>();    // 조사해야 하는 칸 목록
        nodes = new ArrayList<>();      // 온풍기 목록
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 5) {
                    targets.add(new int[]{i, j});
                } else if (temp > 0) {
                    nodes.add(new Node(i, j, temp));
                }
            }
        }
        targets_size = targets.size();
        nodes_size = nodes.size();

        W = Integer.parseInt(br.readLine());
        block = new int[W][3];
        for (int i = 0; i < W; i++) {
            st = new StringTokenizer(br.readLine());
            block[i][0] = Integer.parseInt(st.nextToken()) - 1;
            block[i][1] = Integer.parseInt(st.nextToken()) - 1;
            block[i][2] = Integer.parseInt(st.nextToken()); // 0인 경우 박스 위에, 1인 경우 박스 오른쪽에 벽
        }
        // 입력 끝

        // 조사해야 하는 목록의 값이 모두 K 이상될 때까지 반복
        while (ResearchState()) {
            // 집에 있는 모든 온풍기에서 바람이 한 번 나옴

            for (int i = 0; i < nodes_size; i++) {
                Node temp = nodes.get(i);
                switch (temp.direct) {  // 온풍기의 방향에 따라 온풍기 바람 순회
                    case 1: // 오른쪽 바라본
                        WarmWindBrow(temp.row, temp.column + 1, temp.direct);
                        break;
                    case 2: // 왼쪽 바라본
                        WarmWindBrow(temp.row, temp.column - 1, temp.direct);
                        break;
                    case 3: // 위쪽 바라본
                        WarmWindBrow(temp.row - 1, temp.column, temp.direct);
                        break;
                    case 4: // 아래쪽 바라본
                        WarmWindBrow(temp.row + 1, temp.column, temp.direct);
                        break;
                }
            }

            // 온도가 조절됨
            ControlAir();
            // 온도가 1 이상인 가장 바깥쪽 칸의 온도가 1씩 감소
            BecauseOfColdWeather();
            // 초콜릿을 하나 먹는다.
            chocolate++;
            if (chocolate > 100) {
                chocolate = 101;
                break;
            }
        }
        bw.write(String.valueOf(chocolate));
        bw.flush();
        bw.close();

    }

    public static void WarmWindBrow(int startRow, int startColumn, int startDirect) {
        Queue<int[]> queue = new LinkedList<>();
        visited = new boolean[R][C];
        queue.offer(new int[]{startRow, startColumn, 5, startDirect});
        visited[startRow][startColumn] = true;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int r = temp[0];
            int c = temp[1];
            int temperature = temp[2];
            int d = temp[3];
            map[r][c] += temperature;
            if (temperature - 1 == 0) continue;
            switch (d) {
                case 1:
                    if (c + 1 < C && WhetherGoOrNot(r, c, 1) && !visited[r][c + 1]) { // 바로 오른쪽
                        queue.offer(new int[]{r, c + 1, temperature - 1, 1});
                        visited[r][c + 1] = true;
                    }
                    if (r - 1 >= 0 && c + 1 < C && WhetherGoOrNot(r, c, 3) && WhetherGoOrNot(r - 1, c, 1) && !visited[r - 1][c + 1]) { // 오른쪽 대각 위
                        queue.offer(new int[]{r - 1, c + 1, temperature - 1, 1});
                        visited[r - 1][c + 1] = true;
                    }
                    if (r + 1 < R && c + 1 < C && WhetherGoOrNot(r, c, 4) && WhetherGoOrNot(r + 1, c, 1) && !visited[r + 1][c + 1]) { // 오른쪽 대각 아래
                        queue.offer(new int[]{r + 1, c + 1, temperature - 1, 1});
                        visited[r + 1][c + 1] = true;
                    }
                    break;
                case 2:
                    if (c - 1 >= 0 && WhetherGoOrNot(r, c, 2) && !visited[r][c - 1]) { // 바로 왼쪽
                        queue.offer(new int[]{r, c - 1, temperature - 1, 2});
                        visited[r][c - 1] = true;
                    }
                    if (r - 1 >= 0 && c - 1 >= 0 && WhetherGoOrNot(r, c, 3) && WhetherGoOrNot(r - 1, c, 2) && !visited[r - 1][c - 1]) { // 왼쪽 대각 위
                        queue.offer(new int[]{r - 1, c - 1, temperature - 1, 2});
                        visited[r - 1][c - 1] = true;
                    }
                    if (r + 1 < R && c - 1 >= 0 && WhetherGoOrNot(r, c, 4) && WhetherGoOrNot(r + 1, c, 2) && !visited[r + 1][c - 1]) { // 왼쪽 대각 아래
                        queue.offer(new int[]{r + 1, c - 1, temperature - 1, 2});
                        visited[r + 1][c - 1] = true;
                    }
                    break;
                case 3:
                    if (r - 1 >= 0 && WhetherGoOrNot(r, c, 3) && !visited[r - 1][c]) { // 바로 위쪽
                        queue.offer(new int[]{r - 1, c, temperature - 1, 3});
                        visited[r - 1][c] = true;
                    }
                    if (r - 1 >= 0 && c - 1 >= 0 && WhetherGoOrNot(r, c, 2) && WhetherGoOrNot(r, c - 1, 3) && !visited[r - 1][c - 1]) { // 위 대각 왼쪽
                        queue.offer(new int[]{r - 1, c - 1, temperature - 1, 3});
                        visited[r - 1][c - 1] = true;
                    }
                    if (r - 1 >= 0 && c + 1 < C && WhetherGoOrNot(r, c, 1) && WhetherGoOrNot(r, c + 1, 3) && !visited[r - 1][c + 1]) { // 위 대각 오른쪽
                        queue.offer(new int[]{r - 1, c + 1, temperature - 1, 3});
                        visited[r - 1][c + 1] = true;
                    }
                    break;
                case 4:
                    if (r + 1 < R && WhetherGoOrNot(r, c, 4) && !visited[r + 1][c]) { // 바로 아래쪽
                        queue.offer(new int[]{r + 1, c, temperature - 1, 4});
                        visited[r + 1][c] = true;
                    }
                    if (r + 1 < R && c - 1 >= 0 && WhetherGoOrNot(r, c, 2) && WhetherGoOrNot(r, c - 1, 4) && !visited[r + 1][c - 1]) { // 아래 대각 왼쪽
                        queue.offer(new int[]{r + 1, c - 1, temperature - 1, 4});
                        visited[r + 1][c - 1] = true;
                    }
                    if (r + 1 < R && c + 1 < C && WhetherGoOrNot(r, c, 1) && WhetherGoOrNot(r, c + 1, 4) && !visited[r + 1][c + 1]) { // 아래 대각 오른쪽
                        queue.offer(new int[]{r + 1, c + 1, temperature - 1, 4});
                        visited[r + 1][c + 1] = true;
                    }
                    break;
            }
        }
    }

    public static boolean WhetherGoOrNot(int r, int c, int d) {
        switch (d) {
            case 1: // 오른쪽
                for (int i = 0; i < W; i++) {
                    if (block[i][0] == r && block[i][1] == c && block[i][2] == 1) return false;
                }
                break;
            case 2: // 왼쪽
                for (int i = 0; i < W; i++) {
                    if (block[i][0] == r && block[i][1] == c - 1 && block[i][2] == 1) return false;
                }
                break;
            case 3: // 위쪽
                for (int i = 0; i < W; i++) {
                    if (block[i][0] == r && block[i][1] == c && block[i][2] == 0) return false;
                }
                break;
            case 4: // 아래쪽
                for (int i = 0; i < W; i++) {
                    if (block[i][0] == r + 1 && block[i][1] == c && block[i][2] == 0) return false;
                }
                break;
        }
        return true;
    }

    public static void ControlAir() {
        changed = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int temp = map[i][j];
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] < temp && WhetherGoOrNot(i, j, k + 1)) {
                        int diff = (temp - map[nr][nc]) / 4;
                        changed[i][j] -= diff;
                        changed[nr][nc] += diff;
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                map[i][j] += changed[i][j];
            }
        }
    }

    public static void BecauseOfColdWeather() {
        for (int i = 0; i < R; i++) {
            if (map[i][0] > 0) {
                map[i][0] -= 1;
            }
            if (map[i][C - 1] > 0) {
                map[i][C - 1] -= 1;
            }
        }

        for (int i = 1; i < C - 1; i++) {
            if (map[0][i] > 0) {
                map[0][i] -= 1;
            }
            if (map[R - 1][i] > 0) {
                map[R - 1][i] -= 1;
            }
        }
    }

    public static boolean ResearchState() {
        for (int i = 0; i < targets_size; i++) {
            int[] temp = targets.get(i);
            if (map[temp[0]][temp[1]] < K) return true;
        }
        return false;
    }

    static class Node {
        int row;
        int column;
        int direct;

        public Node(int row, int column, int direct) {
            this.row = row;
            this.column = column;
            this.direct = direct;
        }

    }
}
