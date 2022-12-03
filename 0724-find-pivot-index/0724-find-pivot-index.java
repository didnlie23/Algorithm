class Solution {
    public int pivotIndex(int[] nums) {
        int right = 0;
        int left = 0;
        for(int i=0;i<nums.length;i++){
            right += nums[i];
        }
        right -= nums[0];
        for(int i=1;i<nums.length;i++){
            if (left == right)
                return i - 1;
            left += nums[i-1];
            right -= nums[i];
        }
        if (left == right)
            return nums.length -1;
        return -1;
    }
}