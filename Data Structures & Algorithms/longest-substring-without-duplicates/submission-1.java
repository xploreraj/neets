class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() < 2) return s.length();
        /*
        slow and fast pointers moving and checking each char via set
        */
        Set<Character> set = new HashSet<>();
        int lo = 0, hi = 0;
        char[] ch = s.toCharArray();
        int max = 0;
        while(lo <= hi && hi < ch.length) { // while shrinking it could happen that low and hi converge
            boolean added = set.add(ch[hi]);
            if(added) {
                hi++;
                max = Math.max(max, set.size());
            } else {
                set.remove(ch[lo]);
                lo++;
            }
        }
        return max;
    }
}
