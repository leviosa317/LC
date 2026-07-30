public class LC10 {

    public boolean isMatch(String s, String p) {
        int len_s = s.length() ;
        int len_p = p.length() ;

        boolean[][] dp = new boolean[len_s][len_p] ;

        for(int i = 0 ; i<len_s ; i++){
            for(int j = 0 ; j<i && j<len_p ; j++){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')dp[i][j] = dp[i-1][j-1] ;

                if(p.charAt(j) == '*' && s.charAt(i)==p.charAt(j-1)){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-1] ;
                }
            }
        }

        return dp[len_s -1][len_p-1] ;
    }
}
