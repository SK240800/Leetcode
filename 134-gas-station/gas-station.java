class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int s =0;
        int in= 0;
        int t =0;
        for(int i =0; i<gas.length; i++){
            s += gas[i]-cost[i];
            if(s<0){
                t += s;
                s = 0;
                in = i +1; 
            }
        }
        t += s;
        return t>=0?in:-1;

    }
}