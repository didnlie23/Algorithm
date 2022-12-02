class Solution {
     public List<String> findStrobogrammatic(int n) {
        List<String> oddLengthStr = new ArrayList<>();
        oddLengthStr.add("0");
        oddLengthStr.add("1");
        oddLengthStr.add("8");
        if (n == 1) return oddLengthStr;
        List<String> evenLengthStr = new ArrayList<>();
        evenLengthStr.add("11");
        evenLengthStr.add("69");
        evenLengthStr.add("88");
        evenLengthStr.add("96");
        if (n == 2) return evenLengthStr;
        evenLengthStr.add("00");
        Queue<StringBuilder> queue = new LinkedList<>();
        List<String> result = new LinkedList<>();

        boolean isEven = n % 2 == 0;

        if (isEven) {    // 길이가 짝수일 {
            for (int i = 0, end = evenLengthStr.size(); i < end; i++) {
                queue.offer(new StringBuilder().append(evenLengthStr.get(i)));
            }
        } else {  // 길이가 홀수일 때
            for (int i = 0, end = oddLengthStr.size(); i < end; i++) {
                queue.offer(new StringBuilder().append(oddLengthStr.get(i)));
            }
        }
        int end = evenLengthStr.size() - 1;
        while (!queue.isEmpty()) {
            StringBuilder temp = queue.poll();
            if (temp.length() == n) {
                result.add(temp.toString());
                continue;
            }
            for (int i = 0; i < end; i++) {
                queue.offer(new StringBuilder().append(evenLengthStr.get(i).charAt(0)).append(temp).append(evenLengthStr.get(i).charAt(1)));
            }
            if (temp.length() + 2 != n) {
                queue.offer(new StringBuilder().append(evenLengthStr.get(end).charAt(0)).append(temp).append(evenLengthStr.get(end).charAt(1)));
            }
        }

        return result;
    }
}