class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (isSelfDivisible(i))
                list.add(i);
        }
        return list;
    }
    
    public boolean isSelfDivisible(int num) {
        String str = String.valueOf(num);
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0';
            if (digit == 0 || num % digit != 0) {
                return false;
            }
        }
        return true;
    }
}