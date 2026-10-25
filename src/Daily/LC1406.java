package Daily;

import java.util.Arrays;

public class LC1406 {

    int[] dp ;
    int n ;
    int[] stoneValue ;
    public String stoneGameIII(int[] stoneValue) {
        this.stoneValue = stoneValue ;
        n = stoneValue.length ;
        dp = new int[n] ;

        Arrays.fill(dp, Integer.MIN_VALUE);

        solve(0) ;

        if(dp[0]==0) return "Tie" ;

        if(dp[0] < 0) return "Bob" ;

        if(dp[0] > 0) return "Alice" ;

        return "" ;
    }

    public int solve(int i){
        if(i>=n) return 0 ;

        if(dp[i] != Integer.MIN_VALUE)return dp[i] ;

        int currentStone = 0 ;

        int maxDiff = 0 ;

        for(int j = 0 ; j<3 && i+j < n; j++){
            currentStone += stoneValue[i+j] ;

            maxDiff = Math.max(currentStone - solve(i+j+1) , maxDiff) ;
        }

        dp[i] = maxDiff ;

        return maxDiff ;
    }
}
