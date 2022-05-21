class Solution {
    public String multiply(String num1, String num2) {
        if (num1.length() == 1 && num1.charAt(0) == '0' || num2.length() == 1 && num2.charAt(0) == '0')
            return "0";
    
        if (num2.length() > num1.length()) {
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        
        String[] products = new String[num2.length()];
        int carry = 0, k = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            int d1 = num2.charAt(i) - '0'; 
            StringBuilder sb = new StringBuilder();
            for (int j = num1.length() - 1; j >= 0; j--) {
                int d2 = num1.charAt(j) - '0';
                int res = d2*d1 + carry;
                carry = res / 10;
                sb.append(res%10);
            }
            if (carry > 0) {
                sb.append(carry);
                carry = 0;
            }

            if (k > 0) {
                for (int l = 0; l < k; l++)
                    sb.insert(0, 0);
            }
            products[k++] = sb.toString();   
        }

        StringBuilder sb = new StringBuilder();
        carry = 0;
        for (int j = 0; j < products[k-1].length(); j++) {
            int sum = 0; 
            for (int i = 0; i < k; i++) {
                sum += getChar(products[i], j);
            }
            sum += carry;
            carry = sum / 10;
            sb.append(sum%10);
        }
        if (carry > 0) 
            sb.append(carry);
        return sb.reverse().toString();
    }
    
    private int getChar(String s, int i) {
        if (i < 0 || i >= s.length())
            return 0;
        return s.charAt(i) - '0';
    }
}