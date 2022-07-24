class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] f = new int[26];
        for (char c: tasks) {
            f[c - 'A']++;
        }
        Arrays.sort(f);
        
        int chunks = f[25] - 1;
        int idle_spaces = chunks * n;
        
        for (int i = 24; i >= 0; i--) {
            idle_spaces -= Math.min(chunks, f[i]);
        }
        
        return idle_spaces > 0 ? tasks.length + idle_spaces : tasks.length;
    }
}