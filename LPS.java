public class LPS {
    public static int longestPalindromicSubsequence(String s, int n, int m, int dp[][]) {
        if (n == 0 || m == 0) {
            return 0; 
        }

        if(m == n) {
            return 1; 
        }

        if (dp[n][m] != -1) {
            return dp[n][m]; 
        }

        if (s.charAt(n - 1) == s.charAt(m - 1)) {
            dp[n][m] = 1 + longestPalindromicSubsequence(s, n - 1, m - 1, dp); 
        } else {
            int ans1 = longestPalindromicSubsequence(s, n - 1, m, dp);
            int ans2 = longestPalindromicSubsequence(s, n, m - 1, dp);
            dp[n][m] = Math.max(ans1, ans2);
        }

        return dp[n][m];
    }

    public static void main(String args[]) {
        String s = "agbdba";
        int n = s.length();
        int m = n; 
        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1; 
            }
        }

        System.out.println(longestPalindromicSubsequence(s, n, m, dp));
    }   
}
