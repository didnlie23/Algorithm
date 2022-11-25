class Solution {

    public void reverseWords(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }

        left = 0;
        right = 0;
        for (int i = 0, end = s.length; i < end; i++) {
            if (s[i] == ' ') {
                right = i - 1;
                while (left < right) {
                    char temp = s[left];
                    s[left] = s[right];
                    s[right] = temp;
                    left++;
                    right--;
                }
                left = i + 1;
            }
        }
        right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
