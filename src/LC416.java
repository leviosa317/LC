public class LC416 {
    public boolean canPartition(int[] nums) {
        int n = nums.length ;

        int sum = 0 ;

        for(int num : nums){
            sum += num ;
        }

        if(sum %2 != 0 ) return false ;

        int reqd_sum = sum/2 ;

        boolean[][] dp = new boolean[n+1][reqd_sum+1] ;

        for(int i = 0 ; i<=n ; i++){
            dp[i][0] = true ;
        }

        for(int i = 1 ; i<n ;i++){
            for(int j = 1 ; j<=reqd_sum ; j++){
                int num = nums[i-1]  ;

                dp[i][j] = dp[i-1][j] ;

                if(j >= num){
                    dp[i][j] |= dp[i-1][j-num] ;
                }

                if(j==reqd_sum && dp[i][j]) return true ;
            }
        }

        return false ;
    }
}
