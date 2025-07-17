
import java.util.*;
public class MtargetSum {
    public static boolean Targetsum(int num[], int target, int n, boolean dp[][]){
        if(target == 0){
            return true;
        }
        if(n == 0){
            return false;
        }

        if(dp[n][target] != false){
            return dp[n][target];
        }

        if(num[n-1] <= target){
            boolean ans1 = Targetsum(num, target - num[n-1], n-1, dp);
            boolean ans2 = Targetsum(num, target, n-1, dp);
            dp[n][target] = ans1 || ans2;
            return dp[n][target];
        } else {
            dp[n][target] = Targetsum(num, target, n-1, dp);
            return dp[n][target];
        }
    }

    public static void main(String args[]){
        int num[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int target = 10;
        boolean dp[][] = new boolean[num.length + 1][target + 1];
        for(boolean arr[] : dp){
            Arrays.fill(arr, false);
        }
        dp[0][0] = true;

        System.out.println(Targetsum(num, target, num.length, dp));
    }
}
