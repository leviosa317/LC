public class LC394 {


    public String decodeString(String s) {
        StringBuilder str = new StringBuilder() ;
//        StringBuil p = "" ;
//
        int i =0 ;

        boolean open = false ;;
        int num = 0 ;
        while(i<s.length()){
                num = s.charAt(i) -'0' ;
                i++ ;

            StringBuilder p = new StringBuilder() ;

            if(s.charAt(i)=='['){

                while(i<s.length() || s.charAt(i) != ']'){
                    p.append(s.charAt(i++)) ;
                }
//                open = true ;
            }

            if(s.charAt(i)==']'){
//                open = false ;
                int j =0 ;
                while(j<num){
                    str.append(p) ;
                    j++ ;
                }
            }
        }

    return str.toString() ;

//    Stack<>










    }
}
