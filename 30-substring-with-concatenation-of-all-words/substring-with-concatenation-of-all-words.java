class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String,Integer> map = new HashMap();

        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }

        List<Integer> result = new ArrayList();
        int wc = words.length;
        int wl = words[0].length();
        int totalLen = wc * wl;

        // FIX: Use sliding window for each possible offset to efficiently handle large/overlapping cases
        for(int offset = 0; offset < wl; offset++){
            int left = offset, right = offset, count = 0;
            Map<String,Integer> seen = new HashMap();
            while(right + wl <= s.length()){
                String nw = s.substring(right, right + wl);
                right += wl;
                if(map.containsKey(nw)){
                    seen.put(nw, seen.getOrDefault(nw,0)+1);
                    count++;
                    // Shrink window if too many of nw
                    while(seen.get(nw) > map.get(nw)){
                        String leftWord = s.substring(left, left+wl);
                        seen.put(leftWord, seen.get(leftWord)-1);
                        left += wl;
                        count--;
                    }
                    if(count == wc){
                        result.add(left);
                        // Remove the leftmost word to make space for the next window
                        String leftWord = s.substring(left, left+wl);
                        seen.put(leftWord, seen.get(leftWord)-1);
                        left += wl;
                        count--;
                    }
                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}