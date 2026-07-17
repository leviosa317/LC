import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;

public class LC1584 {


    public int calculate_weight(int[] n1, int[] n2){
        return Math.abs(n1[0] - n2[0]) + Math.abs(n1[1]-n2[1]) ;
    }
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> (n1[0] - n2[0])) ;
        HashSet<Integer> visited = new HashSet<>() ;
        visited.add(0) ;

        int n = points.length ;

        for(int i = 1 ; i<n ; i++){
            int w = calculate_weight(points[0],points[i]) ;
            pq.add(new int[]{w,0,i}) ;
        }

        int cost = 0 ;

        while (visited.size() < n){
            int[] curr = pq.poll() ;

            int w1 = curr[0] ;
            int n1 = curr[1] ;
            int n2 = curr[2] ;

            if(visited.contains(n2))continue ;

            visited.add(n2) ;
            cost += w1 ;

            for(int i = 0 ; i<n ; i++){
                if(i == n2 || visited.contains(i)) continue ;

                int w = calculate_weight(points[n2],points[i]) ;

                pq.add(new int[]{w,n2,i}) ;
            }
        }

        return cost ;

    }
}
