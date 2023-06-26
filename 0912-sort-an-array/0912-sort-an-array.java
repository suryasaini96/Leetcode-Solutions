class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length-1);
        return nums;
    }
    
    public void mergeSort(int[] nums, int i, int j) {
        if (i < j) {
            int mid = i + (j - i)/2;
            mergeSort(nums, i, mid);
            mergeSort(nums, mid + 1, j);
            merge(nums, i, mid, j);  
        }
    }
    
    public int[] merge(int[] nums, int i, int mid, int j) {
        int n = mid - i + 1, m = j - mid;
        int[] l = new int[n];
        int[] r = new int[m];
        for (int k = 0; k < n; k++) {
            l[k] = nums[k + i];
        }
        for (int k = 0; k < m; k++) {
            r[k] = nums[mid + k + 1];
        }
        
        int x = 0, y = 0, k = i;
        while (x < n || y < m) {
            if (x < n && y < m) {
                if (l[x] < r[y])
                    nums[k++] = l[x++];
                else
                    nums[k++] = r[y++];
            } else if (x < n) {
                nums[k++] = l[x++];
            } else if (y < m) {
                nums[k++] = r[y++];
            }
        }
        return nums;
    }
}