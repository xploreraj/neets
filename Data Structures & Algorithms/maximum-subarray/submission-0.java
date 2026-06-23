class Solution {
    /*
    use two prefix sum windows
    */
    public int maxSubArray(int[] nums) {
        if(nums.length==1) return nums[0];
        int currentPrefixSum = 0, minPrefixSum = 0, maxSum = Integer.MIN_VALUE;
        for(int num : nums) {
            currentPrefixSum += num;
            int diff = currentPrefixSum - minPrefixSum;
            if(diff > maxSum) {
                maxSum = diff;
            }
            minPrefixSum = Math.min(currentPrefixSum, minPrefixSum);
        }
        return maxSum;
    }

    public int maxSubArrayKadane(int[] nums) {
        if(nums.length==1) return nums[0];
        int curr = 0, max = Integer.MIN_VALUE;
        for(int num : nums) {
            curr = Math.max(curr + num, num);
            max = Math.max(max, curr);
        }
        return max;
    }
}
