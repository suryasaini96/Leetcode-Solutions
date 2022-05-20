class Solution {
    
    // Include and not include approach
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        
        list.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            int size = list.size();
            for (int j = 0; j < size; j++) {
                List<Integer> tempList = new ArrayList<>(list.get(j));
                tempList.add(nums[i]);
                list.add(tempList); 
            }
        }  
        
        return list;
        
    }
    
//     // Backtracking solution
//     public List<List<Integer>> subsets(int[] nums) {
//         List<List<Integer>> list = new ArrayList<List<Integer>>();
//         List<Integer> tempList = new ArrayList<>();
//         backtrack(list, tempList, nums, 0);
//         return list;
//     }
    
//     private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
//         list.add(new ArrayList<>(tempList));
//         for (int i = start; i < nums.length; i++) {
//             tempList.add(nums[i]);
//             backtrack(list, tempList, nums, i+1);
//             tempList.remove(tempList.size() - 1);
//         }
//     }
}