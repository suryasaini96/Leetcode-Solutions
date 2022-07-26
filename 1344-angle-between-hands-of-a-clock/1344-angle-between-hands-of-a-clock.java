class Solution {
    public double angleClock(int hour, int minutes) {
        double angle = Math.abs(0.5*(60*hour - 11*minutes));
        return Math.min(360 - angle, angle);
    }
}