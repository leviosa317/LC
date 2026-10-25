import java.util.HashMap;

public class LC1658 {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;

        int sum =0 ;

        for(int i = 0 ; i<n ; i++){
            sum += nums[i] ;
        }

        int len = 0 ;

        int req = sum -x ;

        if(req == 0) return n ;

        sum = 0 ;

        int left = 0 ;

        for(int right = 0 ; right<n ; right++){
            sum += nums[right] ;

            while(sum > req){
                sum -= nums[left] ;
                left++ ;
            }

            len = Math.min(len, right - left + 1) ;
        }

        if(len == 0) return -1 ;

        return n-len ;
    }
}
