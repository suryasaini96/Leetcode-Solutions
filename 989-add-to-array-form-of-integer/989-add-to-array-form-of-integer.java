import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        // num to List of Numbers
        List<Integer> num1 = Arrays.stream(num).boxed().collect(Collectors.toList());
        
        // Convert k to List of Numbers
        int temp = k;
        ArrayList<Integer> num2 = new ArrayList<Integer>();
        do{
            num2.add(temp % 10);
            temp /= 10;
        } while (temp > 0);
        Collections.reverse(num2);
        
        return addNumbers(num1.size(), num2.size(), num1, num2);
    }
    
    static List<Integer> addNumbers(int n, int m, List<Integer> A, List<Integer> B) {
        List<Integer> result = new ArrayList<Integer>();
        int carry = 0;
        for (n=n-1, m=m-1;n>=0 || m>=0; n--, m--){
            int a = getDigit(n,A);
            int b = getDigit(m,B);
            int sum = a+b+carry;
            carry = sum/10;
            sum = sum%10;
            result.add(sum);
        }
        if (carry==1) result.add(carry);
        Collections.reverse(result);
        return result;
    }

    static int getDigit(int i, List<Integer> list){
        if (i>=0 && i<list.size())
            return list.get(i);
        return 0;
    }
}