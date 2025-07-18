public class M_LCS {
    public static int longestCommonSubsequence(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0; // Base case: if either string is empty
        }

        if (dp[n][m] != -1) {
            return dp[n][m]; // Return already computed value
        }

        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = 1 + longestCommonSubsequence(s1, s2, n - 1, m - 1, dp); // Characters match
        } else {
            int excludeS1 = longestCommonSubsequence(s1, s2, n - 1, m, dp); // Exclude character from s1
            int excludeS2 = longestCommonSubsequence(s1, s2, n, m - 1, dp); // Exclude character from s2
            dp[n][m] = Math.max(excludeS1, excludeS2); // Take the maximum of both cases
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1; // Initialize dp array with -1
            }
        }

        System.out.println(longestCommonSubsequence(s1, s2, n, m, dp));
    }
}
