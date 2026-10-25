import java.sql.Array;
import java.util.Arrays;

public class LC741 {

    int[][][] dp ;
    int n ;

    int[][] grid ;

    public int solve(int i, int j, int d){
        if(i >=n && j >=n && i<0 && j<0){
            return 0;
        }

        if(i==0 && j==0 && d == 1) return 0 ;

        if(dp[i][j][d] != -1) return dp[i][j][d] ;

        if(i==n-1 && j==n-1){
            d = 1 ;
        }

        int val = grid[i][j] ;

        if(val == -1) return 0 ;

        grid[i][j] = 0 ;

        if(d==0){
            dp[i][j][d] = val + Math.max(solve(i+1,j,d), solve(i,j+1,d)) ;
        }else{
            dp[i][j][d] = val + Math.max(solve(i-1,j,d),solve(i,j-1,d)) ;
        }

        grid[i][j] = val ;

        return dp[i][j][d] ;
    }
    public int cherryPickup(int[][] grid) {
        n = grid.length;

        dp = new int[n][n][2] ;

        this.grid = grid ;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<n ;j++){
                dp[i][j][0] = -1 ;
                dp[i][j][1] =-1 ;
            }
        }

        return solve(0,0,0) ;
    }
}
