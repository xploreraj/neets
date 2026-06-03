class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            int diff = target - nums[i];
            if(numIdxMap.containsKey(diff)) {
                return new int[]{numIdxMap.get(diff), i};
            }
            numIdxMap.put(nums[i], i);
        }
        return null;
    }
}
