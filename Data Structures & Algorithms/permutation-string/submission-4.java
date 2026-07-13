class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length())
            return false;
        int[] s1freq = new int[26];
        for(int i=0; i<s1.length(); i++)
            s1freq[s1.charAt(i)-'a']++;
        
        int[] s2window = new int[26];
        // create initial window in s2
        // each window is a substring, so we can 
        // just check s1 and s2window freq array match
        int left=0, right=0;
        while(right<s1.length()) {
            s2window[s2.charAt(right)-'a']++;
            right++;
        }
        if(Arrays.equals(s1freq, s2window)) {
            return true;
        }
        // slide and check again
        while(right<s2.length()) {
            s2window[s2.charAt(left)-'a']--;
            left++;
            if(right<s2.length()) {
                s2window[s2.charAt(right)-'a']++;
            }
            right++;
            if(Arrays.equals(s1freq, s2window)) {
                return true;
            }
        }
        return false;
    }
}
