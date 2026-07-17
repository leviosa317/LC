public class LC538 {

    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length ;

        int[] prefix_sum = new int[n] ;
        int sum = 0 ;

        int[] kValues = new int[k] ;

        for(int i = 0 ; i<n ; i++){
            sum += nums[i] ;
            int rem = sum % 7 ;
            prefix_sum[i] = sum ;
            kValues[rem] ++ ;

            if(rem==0) return true ;

            if(kValues[rem] > 1) return true ;
        }

        return false ;
    }
}
