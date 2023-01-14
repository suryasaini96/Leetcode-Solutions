class Solution {
    public String freqAlphabets(String s) {
        String str = "";
        int j = s.length() - 1;
        while (j >= 0) {
            if (s.charAt(j) == '#') {
                String num = String.valueOf(s.charAt(j-2)) + String.valueOf(s.charAt(j-1));
                char c = (char)(96 + Integer.parseInt(num));
                str = c + str;
                j = j - 3;
            } else {
                int num = Character.getNumericValue(s.charAt(j));
                char c = (char)(96 + num);
                str = c + str;
                j--;
            }
        }
        return str;
    }
}