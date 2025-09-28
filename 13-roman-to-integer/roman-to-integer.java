class Solution {
    public int romanToInt(String s) {
        int r = 0;
        int n = s.length();
        Map<Character, Integer> roman = new HashMap<>();
        roman.put('I',1);
        roman.put('V',5);
        roman.put('X', 10);
        roman.put('L', 50);
        roman.put('C', 100);
        roman.put('D', 500);
        roman.put('M', 1000);
        for(int i=0; i< n; i++){
            int value = roman.get(s.charAt(i));
            if(i+1 < n && value < roman.get(s.charAt(i+1)) ){
                r = r - value;
            } else {
                r = r + value;
            }
        }
        return r;       
    }
}