class Solution {
    /*
    consider string AAABABB and k = 1. at any point, max window size posisble is 
    widow len (5 at AAABA) - max count of any char (A=4) <= max changes permitted (k=1)
    thats why increment hi count, check max count of any char (running maxcount vs current char count)
    if its valid, (windowlen - maxcount <= k), do h++; and store max len so far
    if not valid, shrink the window
    */
    public int characterReplacement(String s, int k) {
       int maxlen = 0;
       int low = 0, high = 0;
       // window len - max count <= k is valid
       int maxcount = 0;
       int[] count = new int[26];
       char[] ch = s.toCharArray();
       
        while(high < ch.length) {
            count[ch[high]-'A'] ++;
            maxcount = Math.max(maxcount, count[ch[high]-'A']);
            if((high-low+1) - maxcount > k) {
                // invalid window, shrink left
                count[ch[low]-'A'] --;
                low ++;
            } else {
                maxlen = Math.max(maxlen, high-low+1);
            }
            high ++; // we increment as count of char at high was incremented earlier
        }

        return maxlen;
    }
}
