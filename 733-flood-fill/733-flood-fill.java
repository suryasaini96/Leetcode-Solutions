class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int[][] dirs = new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        int startingColor = image[sr][sc];
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int[] e = q.poll();
                int cr = e[0];
                int cc = e[1];
                if (image[cr][cc] != color) {
                    image[cr][cc] = color;
                    for (int[] dir: dirs) {
                        int nr = cr + dir[0];
                        int nc = cc + dir[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] != color && image[nr][nc] == startingColor)
                            q.add(new int[]{nr, nc});
                    }
                }
            }
        }
        return image;
    }
}