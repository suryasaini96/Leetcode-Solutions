class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> res = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums1) {
            set.add(num);
        }
        
        for (int num: nums2) {
            if (set.contains(num))
                res.add(num);
        }
        
        int ans[] = new int[res.size()];
        int i = 0;
        for (Integer x: res) {
            ans[i++] = x;
        }
        return ans;
    }
}