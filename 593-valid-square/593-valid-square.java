class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        boolean samePoint = false;
        for (int i = 0; i < 2; i++) {
            if (p1[i] == p2[i] && p2[i] == p3[i] && p3[i] == p4[i]) samePoint = true;
            else samePoint = false;
        }
        
        if (samePoint) return false;
        
        // Calculate distance of point pairs with each other
        List<Double> distances = new ArrayList<Double>();
        distances.add(distance(p1, p2));
        distances.add(distance(p1, p3));
        distances.add(distance(p1, p4));
        distances.add(distance(p2, p3));
        distances.add(distance(p2, p4));
        distances.add(distance(p3, p4));
        
        // sort the distances
        Collections.sort(distances);
        
        // If first 4 distances (edges) are equal and last 2 distances (diagnoals) are equal then its a sqaure
        if (distances.get(0).equals(distances.get(1)) && distances.get(1).equals(distances.get(2)) && distances.get(2).equals(distances.get(3))) {
            if (distances.get(4).equals(distances.get(5)))
                return true;
        }
        return false;
    }
    
    private double distance(int[] a, int[] b) {
        double x = Math.pow(a[0]-b[0], 2);
        double y = Math.pow(a[1]-b[1], 2);
        return Math.sqrt(x + y);
    }
    
    
}