import java.util.Stack;

public class LC1111 {
    public int[] maxDepthAfterSplit(String seq) {

        int A=0, B =0 ;

        int[] res = new int[seq.length()] ;

        for(int i = 0 ; i<seq.length() ; i++){
            String s = String.valueOf(seq.charAt(i));
            int x = 0;

            if(s.equals("(")){
                if(A < B){
                    A++ ;
                    x = 1 ;
                }else{
                    B++ ;
                }
            }else{
                if(A > B){
                    A++ ;
                    x = 1 ;
                }else {
                    B++ ;
                }
            }

            res[i] = x ;
        }

        return res ;
    }
}
