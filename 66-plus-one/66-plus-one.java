class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int carry = 0;
        List<Integer> result = new ArrayList<Integer>();
        for (n=n-1; n>=0; n--){
            int a = getDigit(n,digits);
            int b;
            if (n==digits.length-1)
                b = 1;
            else
                b = getDigit(-1,digits);   
            int sum = a+b+carry;
            carry = sum/10;
            sum = sum%10;
            result.add(sum);
        }
        if (carry==1) result.add(carry);

        int[] res = new int[result.size()];
        for (int i=result.size()-1; i>=0; i--){
            res[result.size()-i-1] = result.get(i);
        }
        return res;
    }
    
    static int getDigit(int i, int arr[]){
        if (i>=0 && i<arr.length)
            return arr[i];
        return 0;
    }
}