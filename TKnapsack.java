import java.util.*;

public class TKnapsack {
    public static void main(String args[]){
        int val[] = {25, 15, 14, 10, 45, 30};
        int wt[] = {3, 2, 5, 1, 2, 4};
        
        int w = 7;

        int dp[][] = new int[val.length + 1][w + 1];
        for(int i = 1; i<dp.length; i++){
            for(int j = 1; j<dp[0].length; j++){
                int v = val[i-1];
                int t = wt[i-1];
                if(t <= j){
                    int ans1 = v + dp[i-1][j-t];
                    int ans2 = dp[i-1][j];
                    dp[i][j] = Math.max(ans1, ans2);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }


            }
        }

        System.out.println(dp[dp.length-1][w]);
    }
}
