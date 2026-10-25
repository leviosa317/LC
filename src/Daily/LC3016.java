package Daily;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class LC3016 {
    public int minimumPushes(String word) {
        int[] hash = new int[26] ;

        HashMap<Integer,Integer> map = new HashMap<>() ;

        for(char ch : word.toCharArray()){
            hash[ch-'a'] ++ ;

            if(hash[ch-'a'] != 0){
                map.put(ch-'a',hash[ch-'a']) ;
            }
        }

        Arrays.sort(hash) ;

        int counter = 1 ;
        int j = 0;

        int k = 8 ;
        int steps =0 ;

        for(int i = 25 ; i>=0 ; i--){
            if(j==k){
                j = 0 ;
                counter ++ ;
            }

            steps += hash[i]*counter ;

            j++ ;
        }

        return steps ;
    }
}
