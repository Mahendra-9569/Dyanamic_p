import java.util.*;
public class M_LIS {
    public static int longestIncreasingSubsequence(int arr[], int n,int m, int dp[][], int arr2[] ) {
        if (n == 0 || m == 0) {
            return 0; 
        }

        if (dp[n][m] != -1) {
            return dp[n][m]; 
        }
    if( arr[n - 1] == arr2[m  - 1]) {
        dp[n][m] = 1 + longestIncreasingSubsequence(arr, n - 1, m -1,dp, arr2); 
    } else {
        int ans1 = longestIncreasingSubsequence(arr, n-1, m, dp, arr2);
        int ans2 = longestIncreasingSubsequence(arr, n, m-1, dp, arr2);
        return dp[n][m] = Math.max(ans1, ans2);
    }

    return dp[n][m];
    
}

    public static void main(String args[]) {
        int arr[] = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int n = arr.length;
        int arr2[] = Arrays.copyOf(arr, n); 
        Arrays.sort(arr2); 
        int dp[][] = new int[n + 1][n+1];
        for (int mrr[] : dp) {
            Arrays.fill(mrr, -1); 
        }

        System.out.println(longestIncreasingSubsequence(arr, n, n,dp ,arr2));
    }
}
