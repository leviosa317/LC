package FML_sheet;

import java.util.Scanner;

public class CF_670_D1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Read n (machines) and t (products)
        int n = sc.nextInt();
        long k = sc.nextLong(); // long used in case t is large

        // 2. Read the n machine times into an array
        long[] a = new long[n];
        long[] b = new long[n] ;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        for (int i = 0; i < n; i++) {
            b[i] = sc.nextLong();
        }

        sc.close();

        System.out.println(max_cookies(a,b,k)) ;
    }

    static long max_cookies(long[] a, long[] b, long m){
        long lo = 0 ;

        long hi = 0 ;

        for(int i = 0 ; i<a.length ; i++){
            hi = Math.max(b[i]/a[i], hi) ;
        }
        long ans =0 ;

        while(lo <= hi){
            long mid = lo + (hi-lo)/2 ;

            long m_reqd = 0 ;

            for(int i = 0 ; i<a.length ; i++){
                long reqd = a[i] ;
                long available = b[i] ;

                if(reqd <= available )continue ;

                m_reqd += reqd - available ;
            }

            if(m_reqd <= m){
                ans =mid ;

                lo = mid + 1 ;
            }else{
                hi =mid -1 ;
            }
        }

        return ans ;
    }
}
