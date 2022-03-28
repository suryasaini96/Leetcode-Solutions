class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        Set<Integer> rows = new HashSet<Integer>();
        Set<Integer> cols = new HashSet<Integer>();
        for(int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        Iterator<Integer> rit = rows.iterator();
        Iterator<Integer> cit = cols.iterator();
        while (rit.hasNext()){
            int row = rit.next();
            for (int j=0; j<m; j++){
                matrix[row][j] = 0;
            }
        }
        while (cit.hasNext()){
            int col = cit.next();
            for (int i=0; i<n; i++){
                matrix[i][col] = 0;
            }
        }
    }
}