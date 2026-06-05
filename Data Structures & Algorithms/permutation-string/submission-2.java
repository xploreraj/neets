class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length() > s2.length()) return false;
       if(s1.length() == 1 && s2.length() == 1) return s1.equals(s2);

       // we will use frequency array match
       int[] count1 = new int[26]; // 26 alphabets
       int[] countwindow = new int[26]; // sliding window

       char[] ch1 = s1.toCharArray();
       char[] ch2 = s2.toCharArray();

       for(int i=0; i<ch1.length; i++) {
        count1[ch1[i]-'a']++;
        countwindow[ch2[i]-'a']++;
       }

       int left = 0, right = ch1.length-1;
       while(right < ch2.length) {
        if(Arrays.equals(count1, countwindow)) return true;
        // else slide
        countwindow[ch2[left]-'a'] --;
        if(right + 1 < ch2.length) {
            countwindow[ch2[right+1]-'a'] ++;
        }
        left++;
        right++;
       }
       return false;
    }
}
