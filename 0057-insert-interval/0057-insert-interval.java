class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int idx = 0;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[1] < intervals[i][0]) {
                res.add(newInterval);
                newInterval = intervals[i];      
            } else if (newInterval[0] > intervals[i][1]) {
                res.add(intervals[i]);     
            } else if (newInterval[0] <= intervals[i][1] || newInterval[1] >= intervals[i][0]) {
                // Merge the intervals here into new interval
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }
        res.add(newInterval);
        
        int m = res.size();
        int[][] mat = new int[m][2];
        for (int i = 0; i < m; i++) {
            mat[i] = res.get(i);
        }
        return mat;
    }
}