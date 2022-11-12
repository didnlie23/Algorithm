import java.util.*;
import java.io.*;

public class Main {

	static int[][] map;
	static int n;
	static int m;
	static int count;
	static int max;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken()); // row
		m = Integer.parseInt(st.nextToken()); // column
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		count = 0;
		max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 1) {
					count++;
					max = Math.max(max, bfs(i, j));
				}
			}
		}

		bw.write(count + "\n" + max);
		bw.flush();
		bw.close();

	}

	public static int bfs(int row, int column) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { row, column });
		map[row][column] = 0;

		int size = 0;

		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			size++;
			for (int i = 0; i < 4; i++) {
				int nr = temp[0] + dr[i];
				int nc = temp[1] + dc[i];
				if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 1) {
					queue.offer(new int[] { nr, nc });
					map[nr][nc] = 0;
				}
			}
		}

		return size;
	}
}