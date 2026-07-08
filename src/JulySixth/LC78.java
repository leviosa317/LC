package JulySixth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> Dp = new ArrayList<>() ;

        Dp.add(Arrays.asList()) ;

        for(int i = 0 ; i<nums.length ; i++){
            int num = nums[i] ;
            List<List<Integer>> newDp = new ArrayList<>() ;

            for(List<Integer> lastDp : Dp){
                List<Integer> curr_dp = new ArrayList<>(lastDp) ;
                curr_dp.add(num) ;

                newDp.add(lastDp) ;
                newDp.add(curr_dp) ;
            }

            Dp = newDp ;
        }

        return  Dp ;
    }
}
