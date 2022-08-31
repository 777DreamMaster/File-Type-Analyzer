package search;

public class KMPSearch implements Search {
    @Override
    public boolean search(String s, String pattern) {
        if (s.length() == 0) return false;
        int[] p = prefix(pattern);
        int j = 0;
        int i = 0;

        while (i + pattern.length() - j <= s.length()) {
            if (j >= pattern.length()) return true;
            if (s.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                if (j > 0) j = p[j - 1];
                else i++;
            }
        }
        return false;
    }

    private static int[] prefix(String s) {
        int[] p = new int[s.length()];
        int j = 0;
        for (int i = 1; i < s.length(); i++) {
            while (s.charAt(i) != s.charAt(j) && j > 0) {
                j = p[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) j++;
            p[i] = j;
        }
        return p;
    }
}
