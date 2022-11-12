import java.util.*;
import java.io.*;

public class Main {

	static int R;
	static int C;
	static char[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		int[] start = new int[2];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			String temp = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = temp.charAt(j);
				if (map[i][j] == 'J') { // 지훈이의 위치
					start[0] = i;
					start[1] = j;
				} else if (map[i][j] == 'F') { // 불의 위치
					queue.offer(new int[] { i, j, 'F', -1 });
				}
			}
		}
		queue.offer(new int[] { start[0], start[1], 'J', 0 });
		int answer = 0;
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			if (temp[2] == 'J' && (temp[0] == 0 || temp[0] == R - 1 || temp[1] == 0 || temp[1] == C - 1)) {
				answer = temp[3] + 1;
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if (validPosition(nr, nc)) {
					if (temp[2] == 'J' && map[nr][nc] == '.') {
						queue.offer(new int[] { nr, nc, 'J', temp[3] + 1 });
						map[nr][nc] = 'J';
					} else if (temp[2] == 'F' && (map[nr][nc] == 'J' || map[nr][nc] == '.')) {
						queue.offer(new int[] { nr, nc, 'F', -1 });
						map[nr][nc] = 'F';
					}
				}
			}
		}

		if (answer == 0)
			bw.write("IMPOSSIBLE");
		else
			bw.write(String.valueOf(answer));

		bw.flush();
		bw.close();
	}

	public static boolean validPosition(int row, int column) {
		return (row >= 0 && row < R && column >= 0 && column < C);
	}
}