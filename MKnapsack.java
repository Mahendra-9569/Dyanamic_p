import java.util.*;
public class MKnapsack {
    public static int knapsack(int val[], int wt[], int n, int w, int dp[][]){
        if(n == 0|| w == 0){
            return 0;
        }

        if(dp[n][w] != -1){
            return dp[n][w];
        }

        if(wt[n-1] <= w){
    
            int ans1 = val[n-1] + knapsack(val, wt, n-1, w-wt[n-1], dp);
        
            int ans2 = knapsack(val, wt, n-1, w, dp);
            dp[n][w] = Math.max(ans1, ans2);
            return dp[n][w];
        } else {
            dp[n][w] = knapsack(val, wt, n-1, w, dp);
            return dp[n][w];
        }


        }
    

    public static void main(String[] args) {
        int val[] = {25, 15, 14, 10, 45, 30};
        int wt[] = {3, 2, 5, 1, 2, 4};
        int w = 7;

        int dp[][] = new int[val.length + 1][w + 1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        System.out.println(knapsack(val, wt, val.length, w, dp));
    }
}
