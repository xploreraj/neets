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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() < 2) return true;

        List<Interval> list = new ArrayList<>(intervals);
        Collections.sort(list,
            (a,b) -> a.start == b.start ?  
                Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start));
        Interval curr = list.get(0);
        for(int i=1; i<list.size(); i++) {
            Interval next = list.get(i);
            if(next.start < curr.end) {
                return false;
            }
            curr = next;
        }
        return true;
    }
}
