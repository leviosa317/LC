import java.util.Arrays;

public class LC322 {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length ;

        int[][] dp = new int[n+1][amount+1] ;

        for(int[] p : dp){
            Arrays.fill(p,-1);
        }

        for(int i = 0 ; i<=n ;i++){
            dp[i][0] = 0 ;
        }

        for(int i = 1 ; i<=n ; i++){
            for(int amt = 1 ; amt <= amount ; amt++){
                int coin = coins[i-1] ;

                dp[i][amt] = dp[i-1][amt] ;

                if(coin < amount){
                    dp[i][amt] = Math.min(dp[i][amt],1 + dp[i][amt-coin]) ;
                }
            }
        }

        return dp[n][amount] ;
    }
}
