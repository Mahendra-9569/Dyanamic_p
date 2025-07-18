public class WditDistance {
    public static int editDistance(String s1, String s2, int n, int m, int dp[][]) {
        if (n == 0) {
            return m; 
        }
        if (m == 0) {
            return n;
        }
        if (dp[n][m] != -1) {
            return dp[n][m];
        }
        if (s1.charAt(n - 1) == s2.charAt(m - 1)) {
            dp[n][m] = editDistance(s1, s2, n - 1, m - 1, dp);
        } else {
            int insert = editDistance(s1, s2, n, m - 1, dp);
            int delete = editDistance(s1, s2, n - 1, m, dp);
            int replace = editDistance(s1, s2, n - 1, m - 1, dp);
            dp[n][m] = 1 + Math.min(insert, Math.min(delete, replace));
        }
        return dp[n][m];
    }

    public static void main(String args[]){
        String s1 = "kitten";
        String s2 = "sitting";

        int n = s1.length();
        int m = s2.length();

        int dp[][] = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1; 
            }
        }

        System.out.println(editDistance(s1, s2, n, m, dp));
    }
}
