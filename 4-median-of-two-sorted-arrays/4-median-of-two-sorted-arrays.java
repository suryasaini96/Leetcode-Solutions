class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            
            /* The naive approach could be to just add the two sorted arrays together and then return the median
            
            even numbers             
            median = n/2 and n/2 + 1
             
            odd
            
            median = n/2

            
            max(leftPartX) <= min(rightPartY)
            
            max(leftPartY) <= min(righPartX)
            
            
            else if 
            
            max(leftPartX) >= min(rightPartY) -- too far in left part 
            
            move towards left in X
            
            else
            
            move towards right in X
            
            avg (min(rightPartY) + max)
            

            */
        
            int x = nums1.length;
            int y = nums2.length;
        
            if (x > y){
                return findMedianSortedArrays(nums2, nums1);
            }
        
            int low = 0;
            int high = x;
            
            while (low <= high){
                int partitionX = (low + high)/2;
                int partitionY = (x + y + 1)/2 - partitionX;
                
                int maxLeftX = (partitionX==0) ? Integer.MIN_VALUE : nums1[partitionX -1];             
                int minRightX = (partitionX==x) ? Integer.MAX_VALUE : nums1[partitionX];
                
                
                int maxLeftY = (partitionY==0) ? Integer.MIN_VALUE : nums2[partitionY -1];             
                int minRightY = (partitionY==y) ? Integer.MAX_VALUE : nums2[partitionY];
                
                // found the element
                if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                    
                    if ((x+y)%2 == 0) 
                        return ((double)Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) /2;
                    
                    else
                        return (double)Math.max(maxLeftX, maxLeftY);
 
                }
                
                // move towards the left in X
                else if (maxLeftX > minRightY){
                    high = partitionX - 1;  
                }
                
                // move towards right in X
                else {
                    low = partitionX + 1;
                }
                          
            }
            
        throw new IllegalArgumentException(); // if arrays were not sorted
        
    }
}