class Solution {
    public int kthFactor(int n, int k) {
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        
        for (int i = 1; i*i <= n; i++) {
            if (n % i == 0) {
                firstList.add(i);
                secondList.add(n/i);
            }
        }
        
        // Check duplicate for secondList
        if (secondList.size() >= 1 && firstList.size() >= 1 && firstList.get(firstList.size()-1) == secondList.get(secondList.size()-1))
            secondList.remove(secondList.size()-1);
        
        while (!(secondList.size() == 0)) {
            int last = secondList.size() - 1;            
            firstList.add(secondList.get(last));
            secondList.remove(last);
        }
        
        if (k <= firstList.size())
            return firstList.get(k-1);
        
        return -1;
    }
}