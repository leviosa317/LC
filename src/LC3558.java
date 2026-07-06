import java.lang.reflect.Array;
import java.util.*;

public class LC3558 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        int n = candidates.length ;

        TreeSet<Integer> set = new TreeSet<>() ;

        for(int i = 0 ; i<n ;i++){
            set.add(candidates[i]) ;
        }

        HashMap<Integer,List<List<Integer>>> map = new HashMap<>() ;

        map.put(0,Arrays.asList(new ArrayList<>())) ;

        for(int in : set){
            for(int j = 1 ; j<=target ; j++){
                 int reqd = j- in  ;

                 if(reqd>=0 && map.containsKey(reqd)){

                     List<List<Integer>> existingSums = map.getOrDefault(j,new ArrayList<>()) ;

                     List<List<Integer>> requiredSums = map.get(reqd) ;

                     for(List<Integer> requiredSum : requiredSums){
                         List<Integer> newRS = new ArrayList<>(requiredSum) ;

                         newRS.add(in) ;

                         existingSums.add(newRS) ;
                     }

                     map.put(j,existingSums) ;

                 }
            }
        }

        return map.get(target) ;
    }
}
