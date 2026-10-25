public class LC1140 {

    int[][] dp ;
    public int stoneGameII(int[] piles) {
        int n = piles.length ;

        int M = 1 ;

        int[][] dp = new int[n][n] ;

        int tot_sum = 0 ;

        for(int i = 0 ; i<piles.length ; i++){
            tot_sum += piles[i] ;
        }

        return (tot_sum + dp[0][1])/2 ;
    }

    public int util(int i, int[] piles, int M){
        if(i >= piles.length){
            return 0 ;
        }

        if(dp[i][M] != 0)return dp[i][M] ;

        int curr_val = 0 ;

        int maxDiff = Integer.MIN_VALUE ;

        for(int x = 0 ; x + i < piles.length && x < 2*M;  x++){
            curr_val += piles[i+x] ;

            maxDiff = Math.max(maxDiff, curr_val - util(i+1,piles,Math.max(M,x+1))) ;
        }

        dp[i][M] = maxDiff ;

        return maxDiff ;
    }
}
