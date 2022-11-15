class Solution {

    public int[] plusOne(int[] digits) {
        int plus = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = plus + digits[i];
            stack.push(temp % 10);
            plus = temp / 10;
        }
        if (plus > 0) stack.push(plus);
        int[] answer = new int[stack.size()];
        for (int i = 0,end=stack.size(); i < end; i++) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
