public class McoinChange {
    public static int coinChange(int coins[], int amount, int n, int dp[][]) {
        if (amount == 0) {
            return 1; // One way to make change for 0 amount
        }
        if (n == 0 || amount < 0) {
            return 0; // No coins left or negative amount
        }

        if (dp[n][amount] != -1) {
            return dp[n][amount];
        }

        // Include the coin
        int includeCoin = coinChange(coins, amount - coins[n - 1], n, dp);
        // Exclude the coin
        int excludeCoin = coinChange(coins, amount, n - 1, dp);

        dp[n][amount] = includeCoin + excludeCoin;
        return dp[n][amount];
    }   
    public static void main(String args[]){
        int coins[] = {1, 2, 5};
        int amount = 11;

        int dp[][] = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(coinChange(coins, amount, coins.length, dp));
    }
}
