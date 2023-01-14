class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<Fraction> pq = new PriorityQueue<>(Collections.reverseOrder()); 
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int num = arr[i], denom = arr[j];
                Double value = (double)(num)/denom;
                pq.add(new Fraction(value, num, denom));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        Fraction max = pq.poll();
        return new int[]{max.num, max.denom};
    }
}

class Fraction implements Comparable<Fraction> {
    Double value;
    Integer num;
    Integer denom;
    
    public Fraction(Double value, int num, int denom) {
        this.value = value;
        this.num = num;
        this.denom = denom;
    }
    
    @Override
    public int compareTo(Fraction fraction) {
        return Double.compare(this.value, fraction.value);
    }
}