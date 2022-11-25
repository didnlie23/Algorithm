import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            String str = br.readLine();
            if (str.length() != 7) {
                bw.write("0" + "\n");
                continue;
            }
            if (str.charAt(1) != str.charAt(2) && str.charAt(0) == str.charAt(1) && str.charAt(1) == str.charAt(4) && str.charAt(2) == str.charAt(3) && str.charAt(3) == str.charAt(5) && str.charAt(6) == str.charAt(5))
                bw.write("1" + "\n");
            else bw.write("0" + "\n");
        }
        bw.flush();
        bw.close();
    }
}