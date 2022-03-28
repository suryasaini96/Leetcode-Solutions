class Solution {
    public int[] sortedSquares(int[] A) {
        
	int left = 0;
	int right = A.length-1 ;
	
	int out[] = new int[A.length];

    for (int p = A.length-1; p>=0; p--) {
        if(Math.abs(A[left]) > Math.abs(A[right])) {
            out[p] = A[left]*A[left];
            left++;
        }
        else {
            out[p] = A[right]*A[right];
            right--;
        }
    }
	
	return out; 
         
         
    }
    
}