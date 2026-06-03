/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals.size() < 2) {
            return intervals.size();
        }
        List<Interval> list = new ArrayList<>(intervals);
        Collections.sort(list, (a,b) -> Integer.compare(a.start, b.start));
        // end times, meeting with earliest end sit at top
        Queue<Integer> heap = new PriorityQueue<>();
        heap.offer(list.get(0).end);
        for(int i=1; i<list.size(); i++) {
            int earliestEnd = heap.peek(); // 
            int curStart = list.get(i).start;
            if(curStart >= earliestEnd) {
                heap.poll(); // slot freed since the earlier meeting got finished
            }
            heap.offer(list.get(i).end); // add current end time
        }
        return heap.size();
    }
}
