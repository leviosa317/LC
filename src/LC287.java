public class LC287 {
    public int findDuplicate(int[] nums) {
        int n = nums.length;

        int res = 0 ;

        for(int i = 0 ; i<32 ; i++){
            int x = 0, y = 0 ;

            int mask = 1 << i ;

            for(int num : nums){
                if((num & mask) > 0) x++ ;
            }

            for(int j = 1 ; j<n ; j++){
                if((j&mask) > 0) y++ ;
            }

            if(x > y){
                res |= mask ;
            }
        }

        return res ;
    }
}
