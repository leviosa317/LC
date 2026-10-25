package Daily;

public class LC877 {
    int[] piles ;
    public boolean play(int alicePile, int bobPile, int AorB,int i, int j){
        if(i>j){
            return alicePile > bobPile ;
        }

        if(i+1==j){
            int mx = Math.max(piles[i],piles[j]) ;
            int mn = Math.min(piles[i],piles[j]) ;
            if(AorB == 1){
                alicePile += mx ;
                bobPile += mn ;
            }else{
                alicePile += mn ;
                bobPile += mx ;
            }

            return play(alicePile,bobPile,AorB^1 , i+1, j-1) ;
        }
    return true ;

    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length ;

        int alicePile = 0, bobPile = 0 ;

        return true ;
    }
}
