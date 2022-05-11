class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        int nge[] = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = nums2.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i])
                stack.pop();
            if (map.containsKey(nums2[i])) {
                int index = map.get(nums2[i]);
                if (stack.isEmpty())
                    nge[index] = -1;
                else
                    nge[index] = stack.peek();
            }
            stack.push(nums2[i]);
        }
        return nge;
    }
}