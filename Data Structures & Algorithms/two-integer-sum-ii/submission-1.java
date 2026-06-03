class Solution {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums); // O(nlogn) time
        int left = 0, right = nums.length-1;
        while(left<right) { // O(n/2) time
            int sum = nums[left] + nums[right]; // O(1) space
            if(sum > target) {
                right--;
            } else if(sum < target) {
                left++;
            } else {
                return new int[]{left+1, right+1}; // + 1 for one-index response
            }
        }
        return null;
    }

    public int[] twoSumMap(int[] numbers, int target) {
        // O(n) space, O(n) time
        Map<Integer, Integer> numIdxMap = new HashMap<>();
        for(int i=0; i<numbers.length; i++) {
            int diff = target - numbers[i];
            if(numIdxMap.containsKey(diff)) {
                return new int[]{numIdxMap.get(diff) + 1, i + 1};
            }
            numIdxMap.put(numbers[i], i);
        }
        return null;
    }
}
