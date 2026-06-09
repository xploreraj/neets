class Solution {
    public String minWindow(String s, String t) {
        if(t.length() > s.length() 
            || t.length()==1 && s.length()==1 && !s.equals(t))
            return "";
        
        /*
        brute means check evry substring of length t or more in s and match O(n^2)
        cant use set since we need frequency also for duplicate chars, the count should match
        substring means we need to preserve order of elements in "s"
        */
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int[] tcount = new int[128];
        for(char ch : tchar) {
            tcount[ch]++;
        }

        int count = 0; // running count of matching t chars in s
        int minlen = Integer.MAX_VALUE;
        int startindex = 0; // tracks min len window start
        int left = 0, right = 0; // sliding window over schar (or s)

        // Mental model:
        // think of elastic band, it expands till it absorbs all chars in t
        // find minlen, then shrink from left side till the window becomes invalid again
        // move right
        while(right < s.length()) {
            char rightchar = schar[right];
            if(tcount[rightchar] > 0) {
                count++; // rght char (of s) is present in t
            }
            tcount[rightchar]--; // can go negative also, no issues

            // // finds the first window
            // if(count == t.length()) {
            //     int winlen = right-left+1;
            //     if(winlen < minlen) {
            //         minlen = winlen;
            //         startindex = left;
            //     }
            // }

            // now that the window is valid
            // 1. find the minlen and startindex of that window
            // 2. shrink left until the window becomes invalid i.e. count < t.length()
            while(count == t.length()) {
                int winlen = right- left + 1;
                if(winlen < minlen) {
                    minlen = winlen;
                    startindex = left;
                }
                // shrink left side now, just revert what we did earlier
                char leftchar = schar[left];
                tcount[leftchar]++;
                if(tcount[leftchar] > 0) {
                    // means participated in count earlier
                    count--;
                }
                left++;
            }
            // move forward by expanding
            right++;
        }
        return minlen == Integer.MAX_VALUE ? "" : s.substring(startindex, startindex + minlen);
    }
}
