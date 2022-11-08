class Solution {
    public int[] findBuildings(int[] heights) {
        int length = heights.length-1;
        
        int maxHeight = heights[length];
        Stack<Integer> stack = new Stack<>();
        stack.push(length);
        for(int i=length-1;i>=0;i--){
            if (maxHeight < heights[i]){
                maxHeight = heights[i];
                stack.push(i);
            }
        }
        
        int[] answer = new int[stack.size()];
        int idx = 0;
        while(!stack.isEmpty()){
            answer[idx++] = stack.pop();
        }
        
        return answer;
        
    }
}