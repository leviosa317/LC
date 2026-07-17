import java.util.HashMap;
import java.util.TreeSet;

public class LC560 {

    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>() ;
        int sum = 0 ;
        int reqd = 0 ;
        for(int num : nums){
            sum += num ;

            if(map.containsKey(sum - k)){
                reqd += map.get(sum - k) ;
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1) ;
        }

        return reqd ;

    }
}
