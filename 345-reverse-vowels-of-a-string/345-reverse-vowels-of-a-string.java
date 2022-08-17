class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        StringBuilder sb = new StringBuilder(s);
        int left = 0, right = sb.length() - 1;
        while (left <= right) {
            char leftChar = sb.charAt(left);
            char rightChar = sb.charAt(right);
            if (vowels.contains(leftChar) && vowels.contains(rightChar)) {
                sb.setCharAt(left, rightChar);
                sb.setCharAt(right, leftChar);
                left++; right--;
            } else if (vowels.contains(leftChar)) {
                right--;
            } else if (vowels.contains(rightChar)) {
                left++;
            } else {
                left++; right--;
            }
        }
        return sb.toString();
    }
}