class Solution {
    public int characterReplacement(String s, int k) {
        HashSet<Character> allLetters = new HashSet();

        for(int i = 0; i<s.length(); i++){
            allLetters.add(s.charAt(i));
        }

        int maxLength = 0;
        for(Character letter: allLetters){
            int start = 0;
            int count =0;

            for(int end =0; end<s.length(); end+=1){
                if(s.charAt(end)==letter){
                    count+=1;
                }

                while(!isWindowValid(start, end, count, k)){
                    if(s.charAt(start)==letter){
                        count-=1;
                    }
                    start+=1;
                }
                maxLength=Math.max(maxLength,end+1-start);
            }
        }
        return maxLength;
    }

    private Boolean isWindowValid(int start, int end, int count, int k){
        return end +1 -start - count<=k;
    }
}