package JulySixth;

public class LC70_ez {

    public int climbStairs(int n) {
        //1 or 2 steps

        int[] dp = new int[n] ;

        dp[0] = 1 ;
        dp[1] = 1 ;

        for(int i = 2 ; i<n ; i++){
            dp[i] = dp[i-1] + dp[i-2] + 1;
        }

        return dp[n-1] ;
    }
}
