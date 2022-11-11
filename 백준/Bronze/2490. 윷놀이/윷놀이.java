import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = null;
        int[] frequency = null;
        
        for(int i=0;i<3;i++) {
            st = new StringTokenizer(br.readLine(), " ");
            frequency = new int[2];
            while(st.hasMoreTokens()){
                frequency[Integer.parseInt(st.nextToken())]++;
            }
            switch(frequency[0]){
                case 0:
                    bw.write("E\n");
                    break;
                case 1:
                    bw.write("A\n");
                    break;
                case 2:
                    bw.write("B\n");
                    break;
                case 3:
                    bw.write("C\n");
                    break;
                case 4:
                    bw.write("D\n");
                    break;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}