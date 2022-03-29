class Solution {
    public String largestNumber(int[] nums) {
        // Sort the numbers based on which number is greater upon combining
        // Stream of primitives to stream of objects
        nums = Arrays.stream(nums)
            .boxed()
            .sorted((a,b) -> {
                String x = a.toString();
                String y = b.toString();
                if ((x+y).compareTo(y+x) > 0)
                    return -1;
                return 1;
            }).mapToInt(i -> i.intValue())
            .toArray();
        
        String result = "";
        for (int x: nums)
            result += x;
        
        return result.replaceFirst("^0+(?!$)", ""); // For edge case for removing starting 0's
    }
}