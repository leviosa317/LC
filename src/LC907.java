import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class LC907 {
    int [] dp ;
    int n ;
    int[] nums ;

    HashMap<Integer,Integer> map ;

    boolean solve(int i, int k){
        if(i==n-1) return true ;

        if(i>=n) return false ;

        int[] c = {-1,0,1};

        boolean res = false ;

        for(int j = 0 ; j<3 ; j++){
            int jj = k + c[i] ;

            if(jj > 0 && map.containsKey(jj)){
                res |= solve(map.get(jj),jj) ;
            }
        }

        return res ;
    }
    public boolean canCross(int[] stones) {

        n = stones.length ;

        dp = new int[n] ;

        Arrays.fill(dp,-1);

        nums =nums ;

        for(int i = 0 ; i<n ; i++){
            map.put(stones[i],i) ;
        }

        return solve(0,0) ;
    }

    int modulo = 1000000007 ;
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> st = new Stack<>() ;

        int n = arr.length ;

        int[] left = new int[n] ;

        int[] right = new int[n] ;

        //left[0] = -1 ;

        st.add(0) ;

        for(int i = 0 ; i<n ;i++){
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop() ;
            }

            left[i] = (st.isEmpty()) ? i : st.peek() ;
            st.push(i) ;
        }

        //right[n-1] = -1 ;

        for(int i = n-1 ; i>=0 ; i--){

            while( !st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop() ;
            }

            right[i] = (st.isEmpty()) ? i : st.peek() ;

            st.push(i) ;
        }

        int res =0 ;

        for(int i = 0 ; i<n ; i++){
            int l = i - left[i] + 1 ;

            int r = right[i] - i + 1 ;

            long count = (l + r + l*(r-1))* modulo;

            count = (count*arr[i])%modulo ;

            res += count ;
        }

        return res ;
    }
}
