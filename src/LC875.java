public class LC875 {

    int[] piles ;
    int h ;
    public int minEatingSpeed(int[] piles, int h) {
        this.piles = piles ;
        this.h = h ;

        int l = 1 , r = Integer.MIN_VALUE ;

        for(int pile : piles){
            r = Math.max(r,pile) ;
        }

        while(l<r){
            int mid = l + (r-l)/2 ;

            int am = piles[mid] ;
            boolean res = check(am) ;

            if(res){
                r = mid ;
            }else{
                l = mid + 1 ;
            }
        }

        return l ;
    }

    public boolean check (int k){
        int hours = 0 ;
        for(int i = 0 ; i<piles.length ; i++){
            int pile = piles[i] ;

            hours += (int) Math.ceil((double)pile/(double)k);
        }

        if(hours <= h) return true ;
        return false ;
    }
}
