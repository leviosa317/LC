public class LC214 {

    public String shortestPalindrome(String s) {
        String temp = s + "#" + new StringBuilder(s).reverse() ;

        int[] table = new int[temp.length()] ;

        int index = KMP(temp,table) ;

        return new StringBuilder(s.substring(index)).reverse() + s ;
    }

    public int KMP(String s, int[] table){

        int index =0 ;

        for(int i =1 ; i < s.length() ; i++){

            if(s.charAt(index)==s.charAt(i)){
                table[i] = table[i-1] + 1 ;
                index ++ ;
            }else{
                index = table[i-1] ;

                while(index > 0 && s.charAt(i) != s.charAt(index)){
                    index = table[index-1] ;
                }

                if(s.charAt(i) == s.charAt(index)){
                    table[i] = index + 1 ;
                }

                index = table[i] ;
            }
        }

        return index ;
    }
}
