class Solution {
    public int maxArea(int[] heights) {
        int left = 0, right = heights.length-1;
        int max = 0, curr = 0;
        while(left < right) {
            max = Math.max(max, (right-left) * Math.min(heights[left], heights[right]));
            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return max;
    }
}
