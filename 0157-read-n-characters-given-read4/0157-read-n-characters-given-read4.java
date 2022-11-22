/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {

    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    public int read(char[] buf, int n) {
        int answer = 0;
        int count = Integer.MIN_VALUE;
        outer:while (count != 0) {
            char[] buf4 = new char[4];
            count = read4(buf4);
            for (int i = 0; i < count; i++) {
                buf[answer++] = buf4[i];
                if (answer == n) break outer;
            }
            if (count == 0) break;
        }

        return answer;
    }
}
