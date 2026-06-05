import org.graalvm.collections.Pair;

import java.util.* ;

public class leetcode {
    int n ;
    int[] free ;
    int[][] items ;

    int[][] dp ;

    boolean [] vis ;

    int mini = Integer.MAX_VALUE ;
    int solve(int idx, int budget){
        if(idx == n){
            return budget/mini ;
        }

        if(dp[idx][budget] != -1) return dp[idx][budget] ;

        int copies = 0 ;

        int price = items[idx][1] ;

        if(budget >= price){
            copies = 1 + free[idx] + solve(idx+1,budget-price) ;
        }

        copies = Math.max(copies, solve(idx + 1,budget)) ;

        return dp[idx][budget] = copies ;
    }
    public int maximumSaleItems(int[][] items, int budget) {
        //factor,price .... fj%fi == 0 ;

        n = items.length ;
        free = new int[n] ;
        this.items = items ;
        vis = new boolean[n] ;

        dp = new int[n][budget + 1] ;

        for(int[] p : dp){
            Arrays.fill(p,-1) ;
        }

        for(int i=0 ; i<n ; i++){
            mini = Math.min(mini, items[i][1]) ;
            for(int j = 0 ; j<n ; j++){
                if(i==j) continue ;

                int fj = items[j][0] ;
                int fi = items[i][0] ;

                if(fj % fi == 0)free[i] ++ ;
            }
        }

        return solve(0,budget) ;
    }
}
