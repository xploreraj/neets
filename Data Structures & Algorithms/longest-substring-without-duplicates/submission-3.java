class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left=0, right=0;
        int max=0;
        char[] strCh = s.toCharArray();
        // sliding window which shrinks left if curr char is not same
        while(right < strCh.length) {
            if(set.add(strCh[right])) {
                right++;
                max = Math.max(max, set.size());
            } else {
                set.remove(strCh[left]);
                left++;
            }
        }
        return max;
    }
}
