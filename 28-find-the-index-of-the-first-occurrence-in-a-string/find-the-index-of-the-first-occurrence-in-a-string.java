class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();

        for(int ws =0; ws<=m-n; ws++){

            for(int i=0;i<n;i++){
                if(needle.charAt(i)!=haystack.charAt(ws+i)){
                    break;
                }
                if(i==n-1){
                    return ws;

                }
            }

        }

        return -1;
        
    }
}