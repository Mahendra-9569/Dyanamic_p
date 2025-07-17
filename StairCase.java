import java.util.*;
class StairCase{
    public static int NWays(int n, int dp[]){
       if(n<0){
        return 0;
       }

       if(n == 0){
        return 1;
       }
       if(dp[n] != -1){
        return dp[n];
       }
       int First = NWays(n-1, dp);
       int Second = NWays(n-2, dp);

       return dp[n] = First + Second;
    }
    public static void main(String args[]){
        int n = 5;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        System.out.println(NWays(n, dp));
    }
}