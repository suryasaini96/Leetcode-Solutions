class Solution {
    public String breakPalindrome(String palindrome) {
        char[] str = palindrome.toCharArray();
        for (int i = 0; i < str.length / 2; i++) {
            if (str[i] != 'a') {
                str[i] = 'a';
                return String.valueOf(str);
            }
        }
        str[str.length - 1] = 'b'; // If all are 'a' then replace last char with b
        return str.length < 2 ? "" : String.valueOf(str);
    }
}