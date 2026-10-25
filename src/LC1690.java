import java.util.Arrays;

public class LC1690 {

    int[][] dp ;
    int[] prefix ;

    int n ;

    int util(int i, int j){

//        int rem = n - (j-i+1) ;
        if(i>j) return 0 ;

        if(dp[i][j] != -1){
            return dp[i][j] ;
        }

        dp[i][j] = Math.max(prefix(i,j-1) - util(i,j-1),
                            prefix(i+1,j) - util(i+1,j) );

        return dp[i][j] ;
    }

    int prefix(int i, int j){
        if(i > j) return 0 ;

        int left = i==0 ? 0 : prefix[i-1] ;

        int right = prefix[j] ;

        return right - left ;
    }
    public int stoneGameVII(int[] stones) {
        n = stones.length ;

        prefix = new int[n] ;
        dp = new int[n][n] ;

        for(int[] p : dp){
            Arrays.fill(p,-1);
        }

        int sum = 0 ;
        for(int i = 0 ; i<n ; i++){
            sum += stones[i] ;
            prefix[i] = sum ;
        }

        return util(0,n-1) ;
    }
}
