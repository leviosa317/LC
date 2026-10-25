public class LC1186 {
    int n ;

    int[] alice ;
    int[] bob ;

    boolean[] vis ;
    int[] dp;
    public int util(int steps){
        if(steps > n) return 0 ;

        int res=  Integer.MIN_VALUE ;

        for(int i =0 ; i<n ; i++){
            if(!vis[i]){

                int curr_val = (steps %2 == 0) ? bob[i] : alice[i] ;

                vis[i] = true ;

                res = Math.max(curr_val - util(steps + 1), res) ;

                vis[i] = false ;
            }
        }

        dp[steps] = res ;

        return res ;
    }
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        n = bobValues.length ;

        dp = new int[n] ;

        vis =new boolean[n] ;

        alice = aliceValues ;
        bob = bobValues ;

        int res = util(1) ;

        if(res < 0)return -1 ;

        if(res >0) return 1 ;

        return 0 ;
    }
}
