class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0; i<points.length; i++) {
            Point p = new Point(points[i], squaredDistance(points[i]));
            pq.add(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        
        int[][] ans = new int[pq.size()][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int[] point = p.point;
            ans[i][0] = point[0];
            ans[i][1] = point[1];
            i++;
        }
        
        return ans;
    }
    
    private double squaredDistance(int[] point) {
        return Math.pow(point[0],2) + Math.pow(point[1],2);
    }
}

class Point implements Comparable<Point> {
    int[] point;
    double distance;
    
    @Override
    public int compareTo(Point p) {
        return Double.compare(this.distance, p.distance);
    }
    
    public Point(int[] point, double distance) {
        this.point = point;
        this.distance = distance;
    }
}
