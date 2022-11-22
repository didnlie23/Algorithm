class Solution {

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        LinkedList<Character> queue = new LinkedList<>();
        int start = 0;
        int end = 0;
        int length = s.length();
        int max = 0;
        outer:while (end < length) { // end++; 전에 길이 갱신 필수
            char temp = s.charAt(end);
            int size = queue.size();
            for (int i = 0; i < size; i++) { // queue 내에 존재하는 문자였다면 길이 갱신하고 다음 문자로 이동
                if (queue.get(i) == temp) {
                    max = Math.max(end - start + 1, max);
                    end++;
                    if (i == 0){
                        queue.offer(queue.poll());
                    }
                    continue outer;
                }
            }
            if (size >= 2) {
                char garbage = queue.poll();
                for (int i = end - 1; i >= 0; i--) {
                    if (garbage == s.charAt(i)) {
                        start = i + 1;
                        break;
                    }
                }
            }
            max = Math.max(end - start + 1, max);
            queue.offer(temp);
            end++;
        }
        return max;
    }
}
