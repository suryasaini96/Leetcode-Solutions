class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length<=1)
            return intervals;

        Comparator<int[]> sort = new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return Integer.compare(o1[0], o2[0]);
            }
        };
        Arrays.sort(intervals, sort);
        
        int ptr=0;
        for (int i=1; i<intervals.length; i++){
            int start = intervals[i][0];
            int end = intervals[i][1];

            if (start <= intervals[ptr][1]){
                intervals[ptr][1] = Math.max(intervals[ptr][1], end);
            } else {
                ptr++;
                intervals[ptr][0] = start;
                intervals[ptr][1] = end;
            }
        }

        int res[][] = new int[ptr+1][2];
        for (int i=0; i<=ptr; i++){
            res[i][0] = intervals[i][0];
            res[i][1] = intervals[i][1];
        }
        return res;  
    }
    
    // // Solution 2 : Using stack (extra space)

    // public int[][] mergeIntervals(int[][] intervals) {
    //     if (intervals.length<=1)
    //         return intervals;

    //     Comparator<int[]> sort = new Comparator<int[]>(){
    //         @Override
    //         public int compare(int[] o1, int[] o2){
    //             return Integer.compare(o1[0], o2[0]);
    //         }
    //     };
    //     Arrays.sort(intervals, sort);

    //     Stack<int[]> stack = new Stack<int[]>();
    //     stack.push(intervals[0]);

    //     for (int i=1; i<intervals.length; i++){
    //         int start = intervals[i][0];
    //         int end = intervals[i][1];
    //         if (start <= stack.peek()[1]){ // Merge possible
    //             int arr[] = stack.pop();
    //             stack.push(new int[]{
    //                 arr[0], Math.max(arr[1], end)
    //             });
    //         } else {
    //             stack.push(intervals[i]);
    //         }
    //     }
        
    //     int res[][] = new int[stack.size()][2];
    //     int k=0;
    //     Iterator<int[]> itr = stack.iterator();
    //     while(itr.hasNext()){
    //         int arr[] = itr.next();
    //         res[k][0] = arr[0];
    //         res[k++][1] = arr[1];
    //     }

    //     return res;
    // }
}