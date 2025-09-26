class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        int prefixproduct =1;
        int suffixproduct = 1;

        for(int i =0; i<n; i++){
            result[i]= prefixproduct;
            prefixproduct *= nums[i];
        }
        for(int i = n-1; i>=0; i--){
            result[i] *= suffixproduct;
            suffixproduct *= nums[i];
            
        }
        return result;
        
    }
}