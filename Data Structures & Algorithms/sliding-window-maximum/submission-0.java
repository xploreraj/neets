class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // the response array size is (len - k + 1)
        int[] result = new int[nums.length - k + 1];
        int resultId = 0;
        // create frequency of numbers
        SortedMap<Integer, Integer> count = new TreeMap<>((a,b) -> Integer.compare(b,a));
        for(int i=0; i<k; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }
        result[resultId++] = count.firstKey();
        for(int j=k; j<nums.length; j++) {
            int added = nums[j];
            int evicted = nums[j-k];
            if(count.get(evicted) - 1 == 0) {
                count.remove(evicted);
            } else {
                count.put(evicted, count.get(evicted) - 1);
            }
            count.put(added, count.getOrDefault(added, 0) + 1);
            result[resultId++] = count.firstKey();
        }
        return result;
    }
}
