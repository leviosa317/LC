import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LC1686 {

    public int stoneGameVI(int[] aliceValues, int[] bobValues) {

        PriorityQueue<List<Integer>> q = new PriorityQueue<>((a, b) -> Integer.compare(b.get(0),a.get(0))) ;


        for(int i = 0 ; i<aliceValues.length ; i++){
            q.add(Arrays.asList(aliceValues[i]+bobValues[i],i)) ;
        }

        int i =0 ;

        int alice =0 , bob =0 ;

        while(!q.isEmpty()){
            int x = q.peek().get(1) ;

            if(i %2 != 0){
                alice += x ;
            }else{
                bob += x ;
            }

            q.poll() ;
        }

        return Integer.compare(alice, bob);
    }
}
