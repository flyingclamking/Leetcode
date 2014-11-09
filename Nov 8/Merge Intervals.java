public class Solution {
    
    private Comparator<Interval> intervalComparator = new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    };
    
    public List<Interval> merge(List<Interval> intervals) {
        
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, intervalComparator);
        
        List<Interval> result = new ArrayList<Interval>();
        Interval mark = intervals.get(0);
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= mark.end) {
                mark.end = Math.max(curr.end, mark.end);
            } else {
                result.add(mark);
                mark = curr;
            }
        }
        
        result.add(mark);
        return result;
    }
}