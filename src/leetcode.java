import org.graalvm.collections.Pair;

import java.util.* ;

public class leetcode {

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals,(a,b) ->{
            if(a[1] != b[1]) return Integer.compare(a[0],b[0]) ;

            return Integer.compare(a[0],b[0]) ;
        });

        int i = 1 ;

        int n = intervals.length ;

        if(n <= 1) return intervals ;

        Stack<int[]> st = new Stack<>() ;
        st.push(new int[]{intervals[0][0],intervals[0][1]})  ;

        while(i<n){

            int start = intervals[i][0] ;
            int end = intervals[i][1] ;

            int pStart = st.peek()[0] ;
            int pEnd = st.peek()[1] ;

            while(pEnd >= start){
                st.pop();

                start = Math.min(start,pStart) ;
                end = Math.max(end,pEnd) ;

                if(st.empty())break ;

                pStart = st.peek()[0] ;
                pEnd = st.peek()[1] ;
            }

            st.push(new int[]{start,end}) ;
            i++ ;

        }

        int sz = st.size() ;

        int[][] res = new int[sz][] ;

        for(int j = sz - 1 ; i >= 0 ; i--){
            res[j][0] = st.peek()[0] ;
            res[j][1] = st.peek()[1] ;

            st.pop() ;
        }

        return  res ;
    }
}
