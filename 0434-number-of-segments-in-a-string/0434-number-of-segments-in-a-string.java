class Solution {
    public int countSegments(String s) {
        return ("a " + s).split(" +").length -1;
    }
}