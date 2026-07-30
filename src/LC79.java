import java.util.Arrays;
import java.util.List;

public class LC79 {

    public class TrieNode{
        boolean endOfWord ;
        TrieNode[] trie ;

        public TrieNode(){
            endOfWord = false ;
            trie = new TrieNode[26] ;
        }

    }

    public void addWord(String word, TrieNode root){

        TrieNode curr = root ;

        for(char ch : word.toCharArray()){
            if(curr.trie[ch-'a'] == null){
                curr.trie[ch-'a'] = new TrieNode() ;
            }

            curr = curr.trie[ch-'a'];
        }

        curr.endOfWord = true ;
    }

    public boolean checkWord(String word, TrieNode root){
        TrieNode curr = root ;
        int i = 0 ;

        while(i<word.length()){
            if(curr.trie[word.charAt(i)-'a'] != null){
                curr = curr.trie[word.charAt(i)-'a'] ;
                i++ ;
            }else if(curr.endOfWord){
                System.out.println(word.charAt(i) + " ") ;
                curr = root ;

                if(curr.trie[word.charAt(i)-'a'] != null){
                    curr = curr.trie[word.charAt(i)-'a'] ;
                    i++ ;
                }else return false ;
            }else return false ;
        }

        return curr.endOfWord;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
       TrieNode root = new TrieNode() ;

       for(String str : wordDict ){
           addWord(str,root);
       }

       return checkWord(s,root) ;
    }
}
