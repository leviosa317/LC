package FML_sheet;

import java.util.Scanner;

public class BS_Factory_Machines {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Read n (machines) and t (products)
        int n = sc.nextInt();
        long t = sc.nextLong(); // long used in case t is large

        // 2. Read the n machine times into an array
        long[] k = new long[n];
        for (int i = 0; i < n; i++) {
            k[i] = sc.nextLong();
        }

        sc.close();

        System.out.println(util(k,t)) ;
    }

    public static int util(long[] k, long t){
        long min_time = 0  ,max_time = 0 ;

        for(long kk : k){
            min_time = t*Math.min(kk, min_time) ;
            max_time = t*Math.max(kk, max_time) ;
        }



        while(min_time < max_time){
            long no_of_tasks = 0 ;
            long mid = min_time + (max_time - min_time)/2 ;

            for(long kk : k){
                no_of_tasks += mid/kk ;
            }

            if(no_of_tasks < t){
                min_time = mid + 1 ;
            }else{
                max_time = mid ;
            }
        }

        return (int)min_time ;
    }
}
