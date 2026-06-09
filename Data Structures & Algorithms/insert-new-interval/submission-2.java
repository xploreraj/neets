class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // new interval can come before or in middle or at end
        List<int[]> result = new ArrayList<>();
        if(intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // find insert position, add elements before that to result. 
        int i=0;
        // added others before new interval
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        // now either insert or merge
        int[] current = new int[2]; // merged
        current[0] = newInterval[0];
        current[1] = newInterval[1];
        while(i < intervals.length && intervals[i][0] <= current[1]) {
            current[0] = Math.min(current[0], intervals[i][0]);
            current[1] = Math.max(current[1], intervals[i][1]);
            i++;
        }
        // either current is only newinterval or a merged one with overlaps at this point
        result.add(current);
        while(i<intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[result.size()][2];
        for(int j=0; j<result.size(); j++) {
            ans[j] = result.get(j);
        }
        return ans;
    }
}
