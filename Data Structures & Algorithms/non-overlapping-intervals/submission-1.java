class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]==b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0],b[0]);
        });
        int count = 0;
        int left=0, right=1;
        while(right < intervals.length) {
            if(intervals[right][0] < intervals[left][1]) {
                //overlap, so we throw away right
                // larger end is on right, so we assume removing it posisbly reduces max overlaps
                count++;
                if(intervals[right][1] < intervals[left][1]) {
                    // keep the smaller one
                    left = right;
                }
                right++;
            } else {
                left = right;
                right++;
            }
        }
        return count;
    }
}
