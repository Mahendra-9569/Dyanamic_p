public class TstairCase {
    public static void main(String args[]){
        int n = 5;
        int dp[] = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i<dp.length; i++){
            if(i == 1){
                dp[i] = dp[i-1];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2];
            }
        }

        System.out.println(dp[n]);

    }
}
