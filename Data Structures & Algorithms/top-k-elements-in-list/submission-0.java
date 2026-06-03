class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        // most frequent means count
        List<Integer>[] count = new ArrayList[nums.length + 1];
        
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int index = entry.getValue();
            int num = entry.getKey();
            if(count[index] == null) {
                count[index] = new ArrayList<>();
            }
            count[index].add(num);
        }
        int ansInd=0, countInd = 0;
        // each index refers to frequency and element is a list of all nums with that freq
        for(int i=count.length-1; i >= 0 && k > 0;) {
            if(count[i] == null || count[i].size() == 0) {
                i--;
                continue;
            }
            ans[ansInd++] = count[i].get(0);
            count[i].remove(0);
            k--;

        }

        return ans;

    }
}
