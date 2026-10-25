import java.util.Stack;

public class LC402 {

    public String removeKdigits(String num, int k) {
        Stack<Integer> st = new Stack<>() ;

        for(int i = 0 ; i<=num.length() ;i++){

            int x = (i==num.length()) ? Integer.MIN_VALUE : num.charAt(i) ;

            while((k>0) && !st.isEmpty() && num.charAt(st.peek()) > x){
                st.pop() ;
                k-- ;
            }

            if(i < num.length())st.push(i) ;

        }

        String res = "" ;

        while(!st.isEmpty()){
            res = num.charAt(st.peek()) + res ;
            st.pop() ;
        }

        for(int i= 0 ; i<res.length() ; i++){
            if(res.charAt(i)=='0')
                res = res.substring(i) ;
            else break ;
        }

        return res ;
    }
}
