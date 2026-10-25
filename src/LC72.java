import java.util.HashMap;

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

        dp = new int[word1.length()+1][word2.length()+1] ;

//        return util(0,0) ;

//        Let's try iterative!!

          for(int i =1 ; i<=word1.length() ; i++){
              for(int j = 1; j<=word2.length() ; j++){

                  int steps = Integer.MAX_VALUE ;
                  if(word1.charAt(i-1) == word2.charAt(j-1)){
                     steps = Math.min(dp[i-1][j-1],steps) ;
                  }



                  steps = Math.min(steps,1 + Math.min(dp[i-1][j-1],Math.min(dp[i][j-1],dp[i-1][j]))) ;

                  dp[i][j] = steps ;
              }
          }

          return dp[word1.length()][word2.length()] ;
    }

    //LC76
    public String minWindow(String s, String t) {
        int[] map =new int[128] ;

        for(char ch : t.toCharArray()){
            map[ch] ++ ;
        }

        int counter = t.length() ;

        int end = 0 ;
        int start = 0 ;

        int maxLen = Integer.MAX_VALUE ;
        String res  = ""  ;

        while(end < s.length()){

            if(map[s.charAt(end)] > 0)counter-- ;

            map[s.charAt(end)]-- ;

            while(counter == 0){
                if(maxLen > end - start + 1){
                    maxLen = end - start + 1 ;

                    res = s.substring(start,maxLen) ;
                }

                map[s.charAt(start)] ++ ;

                if(map[s.charAt(start)] > 0){
                    counter++ ;
                }
            }
        }

        return res ;
    }
}
