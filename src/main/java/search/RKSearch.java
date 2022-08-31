package search;

public class RKSearch implements Search {

    private static final int a = 117;
    private static final long q = 173_961_102_589_771L;
    @Override
    public boolean search(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();

        if (m > n) return false;

        long patternHash = 0;
        long sHash = 0;
        long pow = 1;

        for (int i = 0; i < m; i++) {
            patternHash += (long) pattern.charAt(i) * pow;
            patternHash %= q;

            sHash += (long) s.charAt(n - m + i) * pow;
            sHash %= q;

            if (i != m - 1) {
                pow = pow * a % q;
            }
        }

        for (int i = n; i >= m; i--) {
            if (patternHash == sHash) {
                for (int j = 0; j < m; j++) {
                    if (s.charAt(i - m + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                return true;
            }
            if (i > m) {
                sHash = (sHash - s.charAt(i - 1) * pow % q + q) * a % q;
                sHash = (sHash + s.charAt(i - m - 1)) % q;
            }
        }
        return false;
    }
}
