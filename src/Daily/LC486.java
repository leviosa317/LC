package Daily;

public class LC486 {
    //both playing optimally.
    int[][] dp ;
    int n ;
    int[] nums ;
    int util(int i, int j){
        if(i>j) return 0 ;

        if(dp[i][j] == 0) return dp[i][j] ;

        int left = nums[i] ;
        int right = nums[j] ;

        return dp[i][j] = Math.max(left + util(i+1,j), right + util(i,j-1)) ;
    }
    public boolean predictTheWinner(int[] nums) {
        dp = new int[n][n] ;
        this.nums = nums ;

        n = nums.length ;

        int res = util(0,n-1) ;

        return res >= 0;
    }
}
