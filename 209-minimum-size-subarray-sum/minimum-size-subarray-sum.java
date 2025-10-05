class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left =0, right =0, sumW =0;
        int r = Integer.MAX_VALUE;

        for(right=0;right<nums.length;right++){
            sumW += nums[right];

            while(sumW>=target){
                r = Math.min(r,right-left+1);
                sumW -=nums[left++];
            }
        }
        return r == Integer.MAX_VALUE ? 0 : r;

        
    }
}