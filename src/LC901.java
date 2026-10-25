import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC901 {
    class StockSpanner {

        Stack<Integer> st ;
        List<Integer> prices ;
        int day ;

        public StockSpanner() {
            st = new Stack<>() ;
            day = -1 ;
            prices = new ArrayList<>() ;
        }

        public int next(int price) {
            day++ ;
            prices.add(price) ;

            while(st.isEmpty() && prices.get(st.peek()) < price ){
                st.pop() ;
            }

            int top = st.isEmpty() ? -1 : st.peek() ;

            st.add(day) ;

            return day - top ;
        }
    }
}
