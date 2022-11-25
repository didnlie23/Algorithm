import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> map = new HashMap<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(br.readLine().replaceAll("[a-z]", " "));
        while (matcher.find()) {
            if (!map.containsKey(matcher.group())) {
                map.put(matcher.group(), 0);
            }
            map.put(matcher.group(), map.get(matcher.group() + 1));
        }
        bw.write(String.valueOf(map.size()));
        bw.flush();
        bw.close();
    }
}