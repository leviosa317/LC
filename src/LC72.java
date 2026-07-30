public class LC72 {

    String word1 ;
    String word2 ;

    int[][] dp ;
    int util(int i, int j){
        if(i == word1.length() && j == word2.length()){
            return 0 ;
        }

        if(word1.length()==i){
            return word2.length() - j ;
        }

        if(word2.length()==j){
            return word1.length() - i ;
        }

        if(dp[i][j] != 0) return dp[i][j] ;

        int steps = Integer.MAX_VALUE ;
        //delete

        steps = Math.min(steps,util(i+1,j)) ;

        //insert
        steps = Math.min(steps, util(i,j+1)) ;

        //replace
        steps = Math.min(steps,util(i+1,j+1)) ;

        steps ++ ;

        if(word1.charAt(i) == word2.charAt(j)){
            steps = Math.min(steps,  util(i+1,j+1)) ;
        }

        return dp[i][j]=steps ;
    }

    public int minDistance(String word1, String word2) {
        this.word1 = word1 ;
        this.word2 = word2 ;

        dp = new int[word1.length()][word2.length()] ;

        return util(0,0) ;
    }
}
