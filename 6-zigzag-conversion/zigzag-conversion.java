class Solution {
    public String convert(String s, int numRows) {
        if(s.length()<=numRows || numRows == 1 ) return s;
        boolean gd = false;
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int cr =0;
        for(char c : s.toCharArray()){
            rows[cr].append(c);
            if(cr == 0 || cr ==numRows-1){
                gd=!gd;
            }
            cr +=gd ? 1:-1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}