public class LPSubstring {
    public static int longestPalindromicSubstring(String s, int n, int dp[][]) {
        if (n == 0) {
            return 0; 
        }

        if (dp[n][n] != -1) {
            return dp[n][n]; 
        }

        int maxLength = 1; 

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                boolean isPalindrome = true;
                int left = i, right = j;

                while (left < right) {
                    if (s.charAt(left) != s.charAt(right)) {
                        isPalindrome = false;
                        break;
                    }
                    left++;
                    right--;
                }

                if (isPalindrome) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        dp[n][n] = maxLength;
        return dp[n][n];
    }

    public static void main(String args[]) {
        String s = "babad";
        int n = s.length();

        int dp[][] = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = -1; 
            }
        }

        System.out.println(longestPalindromicSubstring(s, n, dp));
    }   
}
