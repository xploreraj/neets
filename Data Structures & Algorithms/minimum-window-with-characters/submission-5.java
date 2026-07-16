class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        if(s.length() == t.length() && s.length()==1) return s.equals(t) ? s : "";

        int[] tcount = new int[128];
        for(int i=0; i<t.length(); i++) {
            tcount[t.charAt(i)] ++;
        }

        int left=0, right=0;
        // int minLeft=0, minLen=Integer.MAX_VALUE;
        // instead of index, store actual substring
        String minWindowSubstr = "";
        int count = 0; // track matching of t in s

        while(right<s.length()) {
            char rchar = s.charAt(right);
            if(tcount[rchar] > 0) // r char is present in t
                count++;
            tcount[rchar]--; // window consumed this char (dont worry about -ve)
            while(count==t.length()) {
                // winndow is formed, find minlen and try to shrink
                int currLen = right-left+1;
                if(minWindowSubstr.isEmpty() ||
                    currLen < minWindowSubstr.length()) {
                    // minLen = currLen;
                    // minLeft = left;
                    minWindowSubstr = s.substring(left, right+1);
                }
                // we started from any char and reached to some extent, i.e. right
                // now after forming the window, we shrink, left moves to first char
                // from left side until the window breaks, thats our substring start
                char lchar = s.charAt(left);
                tcount[lchar]++;
                // if any char was not in t and we did -- earlier, so it went negative
                // this means an non t char will moves towards ceiling ZERO
                // while t chars will move above 0. remember we are checking t chars in s.
                if(tcount[lchar] > 0) {
                    count--; // s char is matching t char so reverse count
                }
                left++; // in next iteration minLeft will catch up to this
            }
            right++;
        }
        return minWindowSubstr;
        // return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }
}
