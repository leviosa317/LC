import java.util.Comparator;
import java.util.PriorityQueue;

public class LC3947 {


    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length ;

        int[] gains = new int[n+1] ;

        int[] freq = new int[n+1] ;

        for(int i = 0 ; i<n ;i++){
            int factor = items[i][0] ;
            freq[factor] ++ ;
        }

        //nlogn for calculating these gains
        for(int f = 1 ; f<=n ; f++){
            for(int m = f ; m<=n ; m = m+f) {
                gains[f] += freq[m] ;
            }

            if(gains[f] > 0) gains[f] -- ;
        }
        //[pU, cost, units]
        PriorityQueue<double[]> pq = new PriorityQueue<>(Comparator.comparingDouble(a -> a[0])) ;

        for (int i = 0 ; i<n ;i++){
            int factor = items[i][0] ;
            int price = items[i][1] ;

            int f = gains[factor];

            if(f>0){
                pq.add(new double[]{(double)price / 2, i, f}) ;
            }else{
                pq.add(new double[]{price,i,0}) ;
            }
        }

        int copies = 0 ;

        while(!pq.isEmpty() && budget > 0){
            double[] top = pq.poll() ;


            int idx = (int)top[1] ;
            int tPrice = items[idx][1] ;
            int f = items[idx][0] ;
            double gain = top[2] ;

            if(tPrice > budget) continue ;

            if(gain > 0){
                int c = budget/(tPrice) ;

                System.out.println("idx " + idx);

                int possibleCopies = Math.min((int)gain,c) ;
                if(possibleCopies == gain){
                    gain = 0 ;
                    pq.add(new double[]{tPrice,idx,gain}) ;
                }else {
                    gain -= c ;
                }

                copies += possibleCopies*2 ;
                budget = budget - (tPrice*possibleCopies) ;
            }else{
                int c = budget / tPrice ;

                copies += c ;

                budget = budget - (c*tPrice) ;
            }
        }

        return copies ;
    }
}
