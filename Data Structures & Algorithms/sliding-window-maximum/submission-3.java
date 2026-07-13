class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        int resultId = 0; // index tracker for filling up result
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // keeps indices
        // form the window
        deque.offer(0);
        for(int i=1; i<k; i++) {
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        result[resultId++] = nums[deque.peekFirst()];
        // Slide the window
        for(int i=k; i<nums.length; i++) {
            // clean out of window indices
            while(!deque.isEmpty() && deque.peekFirst() <= i-k) {
                deque.pollFirst();
            }
            while(!deque.isEmpty() && nums[deque.peekLast()] <= nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);
            result[resultId++] = nums[deque.peekFirst()];
        }
        return result;
    }



    public int[] maxSlidingWindow2(int[] nums, int k) {
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
