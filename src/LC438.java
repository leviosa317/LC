import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC438 {

    int[] s_hash ;
    int[] p_hash ;
    public List<Integer> findAnagrams(String s, String p) {

        int window_length = p.length() ;
        p_hash = new int[26] ;
        s_hash = new int[26] ;

        for(char ch : p.toCharArray()){
            p_hash[ch] ++ ;
        }

        int strt = 0 ;
        List<Integer> res = new ArrayList<>( ) ;

        for(int end = 0 ; end <s.length() ; end++){
//            if(end-strt+1 <= window_length){
//                s_hash[s.charAt(end) - 'a'] ++ ;
//            }else{
//                s_hash[s.charAt(strt) - 'a'] -- ;
//                strt++ ;
//                s_hash[s.charAt(end) - 'a'] ++ ;
//            }

            if(end-strt+1 < window_length){
                s_hash[s.charAt(end) - 'a'] ++ ;
                continue;
            }

            s_hash[s.charAt(end) - 'a'] ++ ;

            if(end-strt + 1 == window_length && check_If_same()) res.add(strt) ;

            s_hash[s.charAt(strt) - 'a'] -- ;
            strt++ ;
        }

        return  res ;
    }

    public boolean check_If_same(){
        for(int i = 0 ; i<26 ; i++){
            if(s_hash[i] != p_hash[i]) return false ;
        }

        return true ;
    }
}
