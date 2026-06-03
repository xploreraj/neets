class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int left = 1, right = 1;
        for(int i = 0; i<n; i++) {
            ans[i] = left;
            left = left * nums[i]; // prepare for next iteration
        }
        for(int i = n-1; i>=0; i--) {
            ans[i] = ans[i] * right; // use existing ans value and multiply by right
            right = right * nums[i]; // prepare right for next iteration by using current num
        }
        return ans;
    }
}  
