class Solution {
    public int[] shortestToChar(String s, char c) {
        int[] distance = new int[s.length()];
        int idx = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c) {
                idx = i;
            } else if (idx != -1 && s.charAt(i) != c) {
                distance[i] = i - idx;
            }
        }
        
        idx = -1;
        int[] distance2 = new int[s.length()];
        for (int j = s.length()-1; j >=0; j--) {
            if (s.charAt(j) == c) {
                idx = j;
            } else if (idx != -1 && s.charAt(j) != c) {
                distance2[j] = idx - j;
            }
        }
        
        for (int i = 0; i < s.length(); i++) {
            if (distance[i] > 0 && distance2[i] > 0)
                distance[i] = Math.min(distance[i], distance2[i]);
            else if (distance[i] == 0 && distance2[i] > 0)
                distance[i] = distance2[i];
        }
        return distance;
    }
}