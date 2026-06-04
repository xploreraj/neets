class Solution {
    /*
    consider string AAABABB and k = 1. at any point, max window size posisble is 
    widow len (5 at AAABA) - max count of any char (A=4) <= max changes permitted (k=1)
    thats why increment hi count, check max count of any char (running maxcount vs current char count)
    if its valid, (windowlen - maxcount <= k), do h++; and store max len so far
    if not valid, shrink the window
    */
    public int characterReplacement(String s, int k) {
        int lo = 0, hi = 0;
        char[] ch = s.toCharArray();
        int[] freq = new int[26];
        int maxlen = 0;
        int maxcount = 0; // max count of any char so far
        while(hi < ch.length) {
            freq[ch[hi]-'A'] ++; // blind add
            maxcount = Math.max(freq[ch[hi]-'A'], maxcount);
            if((hi-lo+1) - maxcount > k) {
                // if window is invaid, having more chars than we can change, shrink it
                // our window already added hi, so we will do hi++ anyways
                freq[ch[lo]-'A'] --;
                lo ++;
            } else {
                maxlen = Math.max(maxlen, hi-lo+1);
            }

            hi++;
        }
        return maxlen;
    }
}
