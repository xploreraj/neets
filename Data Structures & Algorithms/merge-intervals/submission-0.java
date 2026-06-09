class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> {
            if(a[0]==b[0]) return Integer.compare(a[1], b[1]);
            else return Integer.compare(a[0], b[0]);
        });
        List<int[]> list = new ArrayList<>();
        int[] curr = intervals[0];
        list.add(curr);
        for(int[] next : intervals) {
            if(next[0] <= curr[1]) {
                curr[1] = Math.max(curr[1], next[1]);
            } else {
                list.add(next);
                curr = next;
            }
        }
        int[][] result = new int[list.size()][2];
        for(int i=0; i<list.size(); i++) {
            result[i][0] = list.get(i)[0];
            result[i][1] = list.get(i)[1];
        }
        return result;
    }
}
