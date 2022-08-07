class Solution {
    
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        
        Pair pairs[] = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(nums[i], i);
        }
        
        mergeAndCount(pairs, 0, n-1, res);
        List<Integer> result = new ArrayList<>();
        for(int i: res) {
            result.add(i);
        }
        return result;   
    }
    
    private void mergeAndCount(Pair pairs[], int left, int right, int result[]) {
        if (left >= right)
            return;
        
        int mid = left + (right-left)/2;
        mergeAndCount(pairs, left, mid, result);
        mergeAndCount(pairs, mid+1, right, result);
        
        int start = left;
        int end = mid + 1;
        
        ArrayList<Pair> merge = new ArrayList<>();
        int right_smaller_count = 0;
        
        while (start <= mid && end <= right) {
            if (pairs[end].val < pairs[start].val) {
                // If there is a value at right array smaller than value at left array
                right_smaller_count++;
                
                merge.add(pairs[end]);
                end++;
            } else {
                // If there is a value at left array smaller than value at right array
                result[pairs[start].originalIndex] += right_smaller_count;
                
                merge.add(pairs[start]);
                start++;
            }
        }
        
        // Merge remaining elements
        while (start <= mid) {
            result[pairs[start].originalIndex] += right_smaller_count;
            
            merge.add(pairs[start]);
            start++;
        }
        
        while (end <= right) {
            merge.add(pairs[end]);
            end++;
        }
        
        
        int pos = left;
        for (Pair p: merge) {
            pairs[pos] = p;
            pos++;
        }
        
    }
    
    
    private class Pair {
        int val;
        int originalIndex;
        
        public Pair(int val, int originalIndex) {
            this.val = val;
            this.originalIndex = originalIndex;
        }
    }
    
}