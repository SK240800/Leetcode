class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        char[] ss = s.toCharArray();
        char[] ts = t.toCharArray();

        for (int c = 0; c < s.length(); c++) {
            char sc = ss[c];
            char tc = ts[c];

            // If mapping already exists, it must match
            if (mapST.containsKey(sc) && mapST.get(sc) != tc) return false;
            if (mapTS.containsKey(tc) && mapTS.get(tc) != sc) return false;

            // Otherwise, store the new mapping
            mapST.put(sc, tc);
            mapTS.put(tc, sc);
        }

        return true;
    }
}