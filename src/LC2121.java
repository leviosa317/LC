import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC2121 {

    public long[] getDistances(int[] arr) {

        int n = arr.length ;

        long[] intervals = new long[n] ;

        HashMap<Integer, List<Integer>> hash = new HashMap<>() ;

        for(int i = 0 ; i<n ; i++){
            int num = arr[i] ;
            List<Integer> f = hash.getOrDefault(num, new ArrayList<>()) ;

            f.add(num) ;

            hash.put(num,f) ;
        }

        for(int key : hash.keySet()){
            List<Integer> array = hash.get(key) ;

            //O(N)
                int[] pre = new int[array.size()] ;
                int[] post = new int[array.size()] ;

                int x = 0;

                for(int j = 0 ; j<array.size() ; j++){
                    pre[j] = x ;
                    x += array.get(j);
                }

                x = 0 ;

                for(int j = array.size()-1 ; j>=0 ; j--){
                    post[j] = x ;
                    x += array.get(j);
                }

                int sz = array.size();

                for(int i =0  ; i< array.size() ; i++){
                    int curr = array.get(i) ;

                    int res = i*curr- pre[i] + post[i] - (sz - i -1)*curr ;

                    intervals[curr] = res ;
                }
        }

        return intervals ;
    }
}
