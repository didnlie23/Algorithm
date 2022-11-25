import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            setNumberInList(list, target);
            int size = list.size();
            if (size % 2 == 0) {
                bw.write(String.valueOf((Math.min(list.get(size / 2), list.get(size / 2 - 1))))+"\n");
            } else {
                bw.write(String.valueOf((list.get(size / 2)))+'\n');
            }
        }
        bw.flush();
        bw.close();
    }

    public static void setNumberInList(ArrayList<Integer> list, int target) {
        if (list.size() == 0) {
            list.add(target);
            return;
        }
        int left = 0;
        int right = list.size() - 1;

        while(left < right){
            int mid = (left + right) / 2;
            if (list.get(mid) == target) {
                list.add(mid, target);
                return;
            }
            else if (list.get(mid) > target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        if (list.get(left) >= target)
            list.add(left, target);
        else
            list.add(left + 1, target);
    }
}
