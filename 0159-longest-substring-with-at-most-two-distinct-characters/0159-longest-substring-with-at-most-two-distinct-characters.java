class Solution {

        public int lengthOfLongestSubstringTwoDistinct(String s) {
        int max = 0;

        Map<Character, Integer> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int length = s.length();
        while(end < length){
            char temp = s.charAt(end);
            if (map.containsKey(temp)){
                map.put(temp, map.get(temp) + 1);
                max = Math.max(max, end - start + 1);
                end++;
            }else{
                if (map.size() < 2){
                    map.put(temp, 1);
                    max = Math.max(max, end - start + 1);
                    end++;
                }else{
                    while(true){
                        char garbage = s.charAt(start);
                        map.put(garbage, map.get(garbage) - 1);
                        start++;
                        if (map.get(garbage) == 0){
                            map.remove(garbage);
                            break;
                        }
                    }
                }
            }
        }

        return max;
    }
}
