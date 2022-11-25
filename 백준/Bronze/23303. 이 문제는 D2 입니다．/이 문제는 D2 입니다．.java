import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Pattern pattern = Pattern.compile("[Dd]2");
        Matcher matcher = pattern.matcher(br.readLine());
        bw.write(matcher.find()?"D2":"unrated");
        bw.flush();
        bw.close();
    }
}
