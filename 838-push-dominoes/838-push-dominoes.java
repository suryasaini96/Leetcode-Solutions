class Solution {
    public String pushDominoes(String dominoes) {
        int right = -1;
        char[] s = dominoes.toCharArray();
        for (int i = 0; i < s.length; i++) {
            if (s[i] == 'L') {
                if (right == -1) {
                    for (int j = i-1; j >= 0 && s[j] == '.'; j--)
                        s[j] = 'L';
                } else {
                    for (int j = right + 1, k = i - 1; j < k; j++, k--) {
                        s[j] = 'R';
                        s[k] = 'L';
                    }
                    right = -1;
                }
            } else if (s[i] == 'R') {
                if (right != -1) {
                    for (int j = right + 1; j < i; j++)
                        s[j] = 'R';
                }
                right = i;
            }
        }
        if (right != -1) {
            for (int j = right + 1; j < s.length; j++)
                s[j] = 'R';
        }
        return new String(s);
    }
}