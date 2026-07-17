import java.util.Arrays;

public class LC300 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length ;
        int idx = 0 ;

        for(int i = 0 ; i<n ; i++){
            int num = nums[i] ;
            int lo = 0 , hi = idx ;

            if(nums[idx] < num){
                idx++ ;
                nums[idx] = num ;
                break ;
            }
            while(lo<hi){
                int mid = (lo+hi)/2 ;
                int am = nums[mid] ;

                if(am >= num){
                    hi = mid ;
                }else {
                    lo = mid + 1 ;
                }
            }

            nums[lo] = num ;
        }

        return idx + 1 ;
    }
}
