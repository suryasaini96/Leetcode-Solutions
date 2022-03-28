class Solution {
    public String capitalizeTitle(String title) {
        String[] str = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String s: str) {
            if(s.length() <= 2) {
                sb.append(s.toLowerCase() + " ");
            } else {
                sb.append(s.substring(0, 1).toUpperCase());
                sb.append(s.substring(1, s.length()).toLowerCase() + " ");
            }
        }
            
        return sb.toString().trim();
    }
}