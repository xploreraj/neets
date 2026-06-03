class Solution {
    public int[] twoSum(int[] numbers, int target) {
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
