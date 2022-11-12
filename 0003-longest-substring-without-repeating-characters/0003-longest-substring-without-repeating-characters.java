class Solution {

    public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> map = new HashMap<>();

		int start = 0;
		int end = 0;
		int max = 0;

		while (end < s.length()) {
			char c = s.charAt(end);
			map.put(c, map.getOrDefault(c, 0) + 1);
			while (map.get(c) > 1) {
				char a = s.charAt(start);
				map.put(a, map.get(a) - 1);
				start++;
			}
			max = Math.max(max, end - start + 1);
			end++;
		}
		return max;
	}
}
