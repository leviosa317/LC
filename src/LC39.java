import java.util.Arrays;

public class LC39 {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length ;

        int l = 0, r = n - 1 ;

        int L = -1 ;

        while(l<r){
            int mid = (l+r)/2 ;

            int aM = nums[mid] ;
            int aL = nums[l] ;
            int aR = nums[r] ;

            if(aM < target){
                l = mid + 1 ;
            }else if( aM >= target){
                r = mid - 1 ;
            }
        }

        L = l ;

        l = 0; r = n-1 ;

        while(l<r){
            int mid = (l+r)/2 ;

            int aM = nums[mid] ;
            int aL = nums[l] ;
            int aR = nums[r] ;

            if(aM <= target){
                l = mid + 1 ;
            }else if( aM > target){

                r = mid - 1 ;
            }
        }

        return new int[]{L,l} ;
    }
}
