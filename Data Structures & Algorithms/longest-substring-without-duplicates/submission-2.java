class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <2) {
            return s.length();
        }
        int maxlen = 0;
        int low = 0, high = 0;
        char[] ch = s.toCharArray();
        Set<Character> set = new HashSet<>();
        while(high < ch.length) {
            boolean added= set.add( ch[high] );
            if(added) {
                maxlen = Math.max(maxlen, set.size());
                high ++;
            } else {
                set.remove(ch[low]);
                low ++;
            }
        }
        return maxlen;
    }
}
