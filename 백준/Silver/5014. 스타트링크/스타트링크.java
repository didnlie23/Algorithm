import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        int F = Integer.parseInt(strings[0]);   // 최대 높이
        int S = Integer.parseInt(strings[1]);   // 현재 위치
        int G = Integer.parseInt(strings[2]);   // 목표 위치
        int U = Integer.parseInt(strings[3]);   // 올라가는 정도
        int D = Integer.parseInt(strings[4]);   // 내려가는 정도

        boolean[] visited = new boolean[F + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{S, 0});
        visited[S] = true;
        int answer = -1;
        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] == G) {
                answer = temp[1];
                break;
            }
            int goUp = temp[0] + U;
            if (goUp <= F && !visited[goUp]) {
                queue.offer(new int[]{goUp, temp[1] + 1});
                visited[goUp] = true;
            }
            int goDown = temp[0] - D;
            if (goDown > 0 && !visited[goDown]) {
                queue.offer(new int[]{goDown, temp[1] + 1});
                visited[goDown] = true;
            }
        }
        if (answer == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(String.valueOf(answer));
        }
    }
}