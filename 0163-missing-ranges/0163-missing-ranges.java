class Solution {

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        LinkedList<String> answer = new LinkedList<>();
        boolean included = false;
        int length = nums.length;
        if (length == 0){
            makeElement(answer, upper + 1, lower - 1);
            return answer;
        }
        makeElement(answer, nums[0], lower - 1);
        for (int i = 0; i < length - 1; i++) {
            makeElement(answer, nums[i + 1], nums[i]);
        }
        makeElement(answer, upper + 1, nums[length - 1]);
        return answer;
    }

    public static void makeElement(LinkedList<String> answer, int upper, int lower) {
        if (upper - lower == 2)
            answer.add(String.valueOf(lower + 1)); 
        else if (upper - lower > 2)
            answer.add(String.format("%d->%d", lower + 1, upper - 1));
    }
}
