class Solution {
    public List<String> summaryRanges(int[] nums) {
        LinkedList<String> answer = new LinkedList<>();
        int idx = 0;
        int length = nums.length;
        while(idx < length){
            int start = idx;
            while (idx + 1 < length && nums[idx + 1] == nums[idx] + 1){
                idx++;
            }
            makeElement(answer, nums[start], nums[idx]);
            idx++;
        }
        return answer;
    }
    
    public static void makeElement(LinkedList<String> answer, int start, int end){
        if (start == end)
            answer.offer(String.valueOf(start));
        else
            answer.offer(String.format("%d->%d", start, end));
    }
}