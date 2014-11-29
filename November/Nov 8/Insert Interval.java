public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        
        if (intervals == null || newInterval == null) {
            return intervals;
        }
        
        int index = 0;
        int min = newInterval.start;
        int max = newInterval.end;
        List<Interval> result = new ArrayList<Interval>();
        
        for (Interval temp : intervals) {
            if (temp.end < min) {
                index++;
                result.add(temp);
            } else if (temp.start > max) {
                result.add(temp);
            } else {
                min = Math.min(min, temp.start);
                max = Math.max(max, temp.end);
            }
        }
        
        result.add(index, new Interval(min, max));
        
        return result;
    }
}