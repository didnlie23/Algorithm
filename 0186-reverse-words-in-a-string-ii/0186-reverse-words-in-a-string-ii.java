class Solution {

    public void reverseWords(char[] s) {
        ArrayList<ArrayList<Character>> list = new ArrayList<>();
        int length = s.length;
        int frontIndex = 0;
        int backIndex = 0;
        while (frontIndex < length) {
            if (s[frontIndex] == ' ') {
                ArrayList<Character> temp = new ArrayList<>();
                while (backIndex < frontIndex) {
                    temp.add(s[backIndex]);
                    backIndex++;
                }
                backIndex++;
                list.add(temp);
            }
            frontIndex++;
        }
        ArrayList<Character> temp = new ArrayList<>();
        while (backIndex < frontIndex) {
            temp.add(s[backIndex]);
            backIndex++;
        }
        list.add(temp);
        int accum = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            temp = list.get(i);
            int size = temp.size();
            for (int j = 0; j < size; j++) {
                s[j + accum] = temp.get(j);
            }
            s[accum + size] = ' ';
            accum += size + 1;
        }
        temp = list.get(0);
        int size = temp.size();
        for (int j = 0; j < size; j++) {
            s[j + accum] = temp.get(j);
        }
    }
}
