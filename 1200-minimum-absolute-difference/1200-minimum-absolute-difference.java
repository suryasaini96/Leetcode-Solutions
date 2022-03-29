class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(arr);
        int absMinDiff = absoluteMinDiff(arr);
        for (int i=1; i<arr.length; i++) {
            if (arr[i] - arr[i-1] == absMinDiff) {
                List<Integer> pair = new ArrayList<Integer>();
                pair.add(arr[i-1]); pair.add(arr[i]);
                result.add(pair);
            }
        }
        return result;
    }
    
    static int absoluteMinDiff(int[] arr) { // must be sorted Array
        int diff = Integer.MAX_VALUE;
        for (int i=1; i<arr.length; i++) {
            if (arr[i]-arr[i-1] < diff)
               diff = arr[i]-arr[i-1];
        }
        return diff;
    }
}