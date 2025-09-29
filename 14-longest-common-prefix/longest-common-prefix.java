class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return"";

        String pref = strs[0];
        int preflen = pref.length();


        for(int i=1;i<strs.length;i++){
            String s = strs[i];
            while(preflen>s.length() || !pref.equals(s.substring(0,preflen))){
                preflen--;
                if(preflen == 0){
                    return "";
                }
                pref = pref.substring(0,preflen);
            } 
        }
        return pref;
        
    }
}