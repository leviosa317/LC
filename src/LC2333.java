import java.util.HashMap;
import java.util.PriorityQueue;

public class LC2333 {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length ;

        int[] diff = new int[n] ;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) ->{
            return Integer.compare(b,a)  ;
        }) ;

        HashMap<Integer, Integer> hash = new HashMap<>() ;

        for(int i = 0 ; i<n ; i++){
            diff[i] = Math.abs(nums1[i] - nums2[i]) ;

            hash.put(diff[i], hash.getOrDefault(diff[i], 0) + 1) ;
        }

        for(int key : hash.keySet()){
            pq.add(key) ;
        }

        int tot = k1 + k2 ;

        while(tot > 0){
            int x = pq.poll() ;

            if(x==0) break ;

            int y = !pq.isEmpty() ? pq.peek() : 0 ;

            int x_f = hash.get(x) ;
            int y_f = hash.get(y) ;

            int dif = x - y ;

            if( dif*(x_f) <= tot){
                hash.remove(x) ;
                tot -= dif*(x_f) ;
//                x = y ;
                hash.put(y,hash.get(y) +x_f) ;
                
            }else{
                int res = tot/x_f ;
                int rem = tot % x_f ;

                //x decreases by res value : x_f ; rem no of x decrease by res + 1 value.
                tot = 0 ;
                if(res > 0){
                    pq.contains(x-res) ;
                    if(!hash.containsKey(x-res))pq.add(x-res) ;
                    hash.put(x-res, hash.getOrDefault(x-res,0)+x_f-rem) ;

                    hash.remove(x) ;
                }

                if(rem >0){
                    if(!hash.containsKey(x-res-1))pq.add(x-res -1) ;
                    hash.put(x-res-1,  hash.getOrDefault(x-res-1,0)+rem) ;
                }
            }
        }

        long res = 0 ;

        while(!pq.isEmpty()){
            long x = (long)pq.poll();

            res += x*x*((long)hash.get((int)x)) ;
        }

        return res ;
    }
}
