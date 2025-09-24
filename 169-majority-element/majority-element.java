class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int r =0;
        int m =0;

        for(int n : nums){
            hash.put(n,1+hash.getOrDefault(n,0));
            if(hash.get(n)>m){
                r=n;
                m=hash.get(n);
            }
        }

        return r;
    }
}
