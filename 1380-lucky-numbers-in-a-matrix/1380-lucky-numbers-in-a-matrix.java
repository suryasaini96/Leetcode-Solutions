class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int[] row = new int[matrix.length];
        int[] col = new int[matrix[0].length]; 
        
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < row.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < col.length; j++) {
                int ele = matrix[i][j];
                min = Math.min(min, ele);
            }
            row[i] = min;
        }
        
        for (int j = 0; j < col.length; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < row.length; i++) {
                int ele = matrix[i][j];
                max = Math.max(max, ele);
            }
            col[j] = max;
        }
        
        for (int i = 0; i < row.length; i++) {
            for (int j = 0; j < col.length; j++) {
                int ele = matrix[i][j];
                if (ele == row[i] && ele == col[j]) {
                    list.add(ele);
                }
            }
        }
        
        return list;
    }
}