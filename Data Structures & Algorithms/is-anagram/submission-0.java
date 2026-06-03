class Solution {
    public boolean isAnagram(String s, String t) {
        if(s==null || t==null || s.length() != t.length()) return false;
        int[] freq = new int[26];
        for(char ch : s.toCharArray()) {
            freq[ch-'a']++;
        }
        for(char ch : t.toCharArray()) {
            int idx = ch-'a';
            freq[idx]--;
            if(freq[idx] < 0) {
                return false;
            }
        }
        return true;
    }
}
