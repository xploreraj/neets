class Solution {
    public int characterReplacement(String s, int k) {
        int left =0, right=0;
        int[] freq = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        while(right < s.length()) {
            char rchar = s.charAt(right);
            freq[rchar - 'A'] ++;
            maxFreq = Math.max(maxFreq, freq[rchar-'A']);
            if((right-left+1) - maxFreq > k) {
                // current window - total count of higher freq chars
                //    = num of other characters, for which k replacement can be made. 
                // 2 chars and k=1 means one char is extra which cant be replaced
                // and breaks the substring rule
                char lchar = s.charAt(left);
                freq[lchar-'A']--;
                left++;
                // we can decrease max freq here 
                // but since only go towards finding greater
                // we can leave it as it is
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}
