import java.util.Stack;

public class LC32 {

    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>() ;

        int maxLen = 0 ;

        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == '(')st.add(i) ;
            else {
                if(!st.isEmpty() && s.charAt(st.peek()) == '('){
                    maxLen = Math.max(maxLen,i-st.peek() + 1) ;
                }else {
                    st.push(i) ;
                }
            }
        }

        return maxLen ;
    }

    int[] nums ;

    public int firstMissingPositive(int[] nums) {
        this.nums = nums ;

        int n = nums.length ;

        int i = 0 ;

        while(i<n){

            if(nums[i] < n && nums[i] >0){
                swap(i,nums[i]) ;
            }

            if(nums[i] == i || nums[i] <= 0 || nums[i] >= n ){
                i++ ;
            }
        }

        int missing = 1 ;

        for(i = 1 ; i<n ; i++){
            if(nums[i] != i){
                return i ;
            }
        }

        if(n>0 && nums[0] == n) return n+1 ;

        return n ;
    }

    public void swap(int i,int j){
        int temp = nums[i] ;
        nums[i] = nums[j] ;
        nums[j] = temp ;
    }
}
