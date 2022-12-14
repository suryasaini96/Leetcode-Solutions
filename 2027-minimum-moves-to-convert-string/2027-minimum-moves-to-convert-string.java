class Solution {
    public int minimumMoves(String s) {
        int moves = 0;
        int i = 0; 
        while (i < s.length()) {
            if (s.charAt(i) == 'O') {
                i++;
            } else {
                moves++;
                i = i+3;
            }
        }
        return moves;
    }
}