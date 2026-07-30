public class LC4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length ;
        int n2 = nums2.length ;

        if(n1>n2) return findMedianSortedArrays(nums2,nums1) ;

        int total = n1 + n2 ;

        int half = total /2 ;

        int l = 0 , r = n1 - 1 ;

        while(l<r){
            int i = (l+r) /2 ;
            int j = half - i - 2 ;

            int Aleft = nums1[i] ;
            int Bleft = nums2[j] ;

            int Aright = (i+1) >= n1 ? Integer.MAX_VALUE : nums1[i+1] ;
            int Bright = (j+1) >= n2 ? Integer.MAX_VALUE : nums2[j+1] ;

            if(Aleft <= Bright && Aright >= Bleft){
                if(total %2 != 0){
                    return Math.max(Aleft,Bleft) ;
                }else {
                    return (Aleft + Bleft) /2.0 ;
                }
            }

            else if (Aleft > Bright){
                r = i - 1 ;
            }else if(Bleft > Aright){
                l = i+ 1 ;
            }
        }

        return Integer.MIN_VALUE ;
    }
}
