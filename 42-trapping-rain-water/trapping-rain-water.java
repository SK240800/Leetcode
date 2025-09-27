class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int [] leftmax = new int[n];
        int [] rightmax = new int[n];
        int water = 0;

        for(int i = 0; i<n; i++){
            if(i==0){
                leftmax[0]=height[0];
                rightmax[n-1]=height[n-1];
            }
            else{
                leftmax[i]=Math.max(height[i],leftmax[i-1]);
                rightmax[n-1-i] = Math.max(height[n-1-i],rightmax[n-i]);
            }

        }
        for(int i =0;i<n;i++){
            water += Math.min(leftmax[i],rightmax[i])-height[i];
        }

        return water;
        
    }
}