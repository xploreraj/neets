class Solution {
    public boolean canJump(int[] nums) {
        int maxJump = 0;
        for(int i=0; i<nums.length-1; i++) {
            // we are inside this step means we have landed here successfully

            // oservation: for two adjacent element, i thnk whether is 10,4 or 5,4 or 
            // 4,5 or 9,10, taking max always wins,
            maxJump = Math.max(maxJump, nums[i]);
            // for moving to next element, we consume one jump from wallet
            maxJump--;
            // with 1 in wallet atleast we can move to next
            // but if wallet has 0, -- turns into negative and we cant jump further
            if(maxJump < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canJump2(int[] nums) {
        int maxReachSoFar = 0;
        for(int i=0; i<nums.length; i++) {
            if(i > maxReachSoFar)
                return false;
            maxReachSoFar = Math.max(maxReachSoFar, i + nums[i]);
            if(maxReachSoFar >= nums.length-1) 
                return true;
        }

        return false;
    }
}
