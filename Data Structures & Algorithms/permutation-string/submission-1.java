class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s2.length() < s1.length()) return false;
        int start = 0, end = s1.length()-1; // for fixed size slifing window in s2
        // idea of total ascii sum of window seems intuitive but fails 
        // since different char combo can produce same result

        char[] ch1 = s1.toCharArray();
        char[] ch2 = s2.toCharArray();

        int[] freq1 = new int[26]; // s1 freq
        int[] freq2 = new int[26]; // s2 window frequency
        for(int i=0; i< ch1.length; i++) {
            freq1[ch1[i] - 'a']++;
            freq2[ch2[i] - 'a']++;
        }

        while(end < s2.length()) {
            if(Arrays.equals(freq1, freq2)) { return true; }
            if(end+1 < s2.length()) {
                char leave = ch2[start];
                char add = ch2[end+1];
                freq2[leave - 'a']--;
                freq2[add - 'a'] ++;
            }
            start++;
            end++;
        }

        return false;
    }
}
