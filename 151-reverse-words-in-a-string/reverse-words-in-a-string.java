class Solution {
    public String reverseWords(String s) {
        int i =0, n= s.length();
        String r = new String();
        while(i<n){
            while(i<n && s.charAt(i)==' '){
                i++;
            }
            if (i >= n) break;
            int j = i+1;
            while(j<n && s.charAt(j)!=' '){
                j++;
            }
            if(r.length()==0){
            r=s.substring(i,j);
            }
            else{
                r=s.substring(i,j)+" "+r;
            }
            i=j+1;
        }
        return r;
               
    }
}