class Solution {
    public char[][] rotateTheBox(char[][] box) {
        int m = box.length, n = box[0].length;
        for (int i = 0; i < m; i++) {
           int emptyBoxLocation = n - 1;
           for (int j = n - 1; j >= 0; j--) {
               if (box[i][j] == '.') { // If char is empty place 
                   if (emptyBoxLocation > j) {
                       continue;
                   }
                   emptyBoxLocation = j; // Set empty box location 
               } else if (box[i][j] == '*') { // If char is stationary box
                   emptyBoxLocation = j - 1; // Skip the box
               } else if (box[i][j] == '#') { // If char is crystal
                   int crystalLocation = j;
                   swap(box, i, crystalLocation, emptyBoxLocation); // Swap the crystal and empty box
                   emptyBoxLocation--;
               }
           }         
        }
    
        char[][] ans = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][m - i - 1] = box[i][j];
            }
        }
        return ans;   
    }
    
    public void swap(char[][] box, int i, int j1, int j2) {
        char temp = box[i][j1];
        box[i][j1] = box[i][j2];
        box[i][j2] = temp;
    }
}