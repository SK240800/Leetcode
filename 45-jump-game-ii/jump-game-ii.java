class Solution {
    public int jump(int[] nums) {
        int c =0, e =0, j=0;
        while(e<nums.length-1){
            int m= 0;
            for(int i = c; i<=e; i++){
                m= Math.max(m,i+nums[i]);
            }
            c= e+1;
            e= m;
            j++;
        }
        return j;
    }

}