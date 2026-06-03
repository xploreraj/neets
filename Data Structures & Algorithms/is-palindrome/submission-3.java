class Solution {
    public boolean isPalindrome(String s) {
        // a-97, A-65, 9-48
        char[] chars = s.toLowerCase().toCharArray();
        int left = 0, right = chars.length-1;
        while(left < right) {
            while(left < right && !isValid(chars[left])) {
                left++;
            }
            while(left < right && !isValid(chars[right])) {
                right--;
            }
            // right and left can be at max at 0 and n-1 respectively
            if(chars[left] != chars[right]) {
                return false;
            }
            left++; right--;
        }
        // at this point either left == right or both have crossed each other post check
        return true;
    }

    private boolean isValid(char c) {
        return c>=48 && c<=48+9 || c>=65 && c<=65+25 || c>=97 && c<=97+25;
    }
}
