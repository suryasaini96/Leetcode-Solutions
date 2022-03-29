class Solution {
    
    // Combining from the end to avoid extra middle manupulation 
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int end = m + n - 1; int nums1End = m - 1; int nums2End = n - 1;
        
        while (nums1End >=0 && nums2End >=0) {
            nums1[end--] = nums1[nums1End] > nums2[nums2End] ? nums1[nums1End--]: nums2[nums2End--]; 
        }
        
        // Case when nums2 elements are remaining
        while (nums2End >=0) {
            nums1[end--] = nums2[nums2End--];
        }   
    }
    
    
    /* // Using ptr logic -- need to modify
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int ptr1 = 0;
        int ptr2 = 0;
        //int res[] = new int[m+n];
        int a,b;

        for (int i=0; i<m+n; i++) {
            if (ptr1>=m && ptr2<n)
                a = nums2[ptr2];
            else   
                a = nums1[ptr1];    
            
            if (ptr2>=n && ptr1<m)
                b = nums1[ptr1];
            else
                b = nums2[ptr2];    

            nums1[i] = Math.min(a, b);

            if (a==b){
                if (ptr1<m)
                    ptr1++;
                else if (ptr2<n)
                    ptr2++;    
            }else{
                if (a>b)
                    ptr2++;
                else if (b>a)
                    ptr1++;
            }
        }
        //return nums1;
    } */
    
}