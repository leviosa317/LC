public class LC115 {
    public int numDistinct(String s, String t) {
        int ns = s.length() ;
        int nt = t.length() ;
        int[][] dp = new int[ns+1][nt + 1] ;

        dp[0][0] = 1 ;

        for(int i =1  ; i<=ns ; i++){
            dp[i][0] = 1 ;
        }

        for(int i = 1 ; i <= ns ; i++){
            for(int j = 1 ; j<= nt ; j++){
                char sc = s.charAt(i-1) ;
                char tc = t.charAt(j-1) ;

                dp[i][j] += dp[i-1][j] ;

                if(sc==tc){
                    dp[i][j] += dp[i-1][j-1] ;
                }
            }
        }

        return dp[ns][nt] ;
    }
}
