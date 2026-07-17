import java.util.Stack;

public class LC739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>() ;

        int n = temperatures.length ;

        int[] res = new int[n] ;

        for(int i = n-1 ; i>=0 ; i--){
            while(!st.isEmpty() && temperatures[st.peek()] <= temperatures[i]){
                st.pop() ;
            }

            if(st.isEmpty()){
                res[i] =0 ;
            }else {
                res[i] = st.peek() - i ;
            }

            st.push(i) ;
        }

        return res ;
    }
}
