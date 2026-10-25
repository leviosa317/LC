public class LC1563 {
    int[][] dp ;
    int[] stoneValue ;

    int solve(int l, int r, int sum){
        if(l==r) return 0 ;

        int left = 0 , right = 0 ;

        int profit = 0 ;

        if(dp[l][r] != 0) return dp[l][r] ;

        for(int i = l ; i<= r ; i++){
            left += stoneValue[i] ;
            right = sum - left ;

            if(left<right){
                profit = Math.max(profit,left + solve(l,i,left)) ;
            }else if(right<left){
                profit = Math.max(profit, right+ solve(i+1,r,right)) ;
            }else{
                int l_or_R = Math.max(left + solve(l,i,left),right + solve(i+1,r,right)) ;

                profit = Math.max(l_or_R,profit) ;
            }
        }

        dp[l][r] = profit ;

        return profit ;
    }
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length ;
        this.stoneValue = stoneValue ;

        dp = new int[n][n] ;

        int tot_sum =0 ;

        for(int val : stoneValue){
            tot_sum += val ;
        }

        return solve(0,n-1, tot_sum) ;
    }
}
