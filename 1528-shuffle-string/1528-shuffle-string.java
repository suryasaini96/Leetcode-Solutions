class Solution {
    public String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        char[] result = new char[s.length()];
        for (int i = 0; i < indices.length; i++) {
            int idx = indices[i];
            result[idx] = arr[i];
        }
        return new String(result);
    }
}