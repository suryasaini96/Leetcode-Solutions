class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        int n = groupSizes.length;
        for (int i = 0; i < n; i++) {
            List<Integer> list = map.getOrDefault(groupSizes[i], new ArrayList<>());
            if (list.size() == groupSizes[i]) {
                res.add(list);
                List<Integer> newList = new ArrayList<>();
                newList.add(i);
                map.put(groupSizes[i], newList);
            } else {
                list.add(i);
                map.put(groupSizes[i], list);
                if (list.size() == groupSizes[i]) {
                    res.add(list);
                    List<Integer> newList = new ArrayList<>();
                    map.put(groupSizes[i], newList);
                }
            }
        }
        return res;
    }
}