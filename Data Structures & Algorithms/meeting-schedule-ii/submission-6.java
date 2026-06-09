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
        if(intervals.size() < 2) return intervals.size();
        // sort input with start then end time
        Collections.sort(intervals, (a,b) -> 
            a.start == b.start ? Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start));
        // min heap based on end time
        Queue<Interval> heap = new PriorityQueue<>((a,b) -> Integer.compare(a.end, b.end));
        for(Interval requestedMeeting : intervals) {
            Interval runningMeeting = heap.peek();
            if(runningMeeting != null && requestedMeeting.start >= runningMeeting.end) {
                heap.poll(); // no overlap, so we will keep latest meeting
            }
            heap.offer(requestedMeeting);
        }
        // the behavior is like min interval rooms are removed as new non overlaps are added,
        // keeping our heap to only contain exclusive meeting rooms
        return heap.size();
    }

    public int minMeetingRooms2(List<Interval> intervals) {
    //    Arrays.sort(intervals, (a,b) -> 
    //     a.start == b.start ? Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start));

        // brute
        int minRooms = 0;
        for(int i=0; i<intervals.size(); i++) {
            int overlap = 1; // book a room for current interval
            for(int j=0; j<intervals.size(); j++) {
                if(i==j) continue;
                // a,b and c,d overlap if a < d & b > c (c < b)
                if(intervals.get(i).start < intervals.get(j).end 
                    && intervals.get(j).start < intervals.get(i).end) {
                    overlap++;
                }
            }
            minRooms = Math.max(minRooms, overlap);
        }
        return minRooms;
    }
}
