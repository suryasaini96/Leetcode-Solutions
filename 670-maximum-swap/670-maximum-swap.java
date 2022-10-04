class Solution {
    public int maximumSwap(int num) {
        int[] buckets = new int[10];
        char[] numArray = Integer.toString(num).toCharArray();
        for (int i = 0; i < numArray.length; i++) {
            buckets[numArray[i] - '0'] = i;
        }
        
        for (int i = 0; i < numArray.length; i++) {
            for (int k = 9; k > numArray[i] - '0'; k--) {
                if (buckets[k] > i) {
                    char temp = numArray[i];
                    numArray[i] = numArray[buckets[k]];
                    numArray[buckets[k]] = temp;
                    return Integer.valueOf(new String(numArray));
                }
            }
        }
        return num;
    }
    
}