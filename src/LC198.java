public class LC198 {
    public int rob(int[] nums) {
        int n = nums.length ;

        int[] dp = new int[n+1] ;

        dp[1] = nums[0] ;

        for(int i = 2 ; i<=n ; i++){
            int x = nums[i-1] ;

            dp[i] = Math.max(dp[i-1],x+dp[i-2]) ;
        }

        return dp[n] ;
    }
}
