import java.util.HashSet;
import java.util.PriorityQueue;

public class LC1584_Kruskal {

    public class UnionFind{
        int[] parent ;
        int[] rank ;

        public UnionFind(int n){
            parent = new int[n] ;
            rank = new int[n] ;

            for(int i = 0 ; i<n ; i++){
                parent[i] = i ;
                rank[i] = 1 ;
            }
        }
        public int find(int i){
           if(parent[i]==i) return i ;
           return parent[i] = find(parent[i]) ;
        }

        public boolean unionFind(int u, int v){
            int rootu = find(u), rootv = find(v) ;

            if(rootu != rootv){

                if(rank[rootu] > rank[rootv]){
                    parent[rootv] = rootu ;
                }else if (rank[rootu] < rank[rootv]){
                    parent[rootu] = rootv ;
                }else {
                    parent[rootu] = rootv ;
                    rank[rootu] ++ ;
                }

                return true ;

            }else return false ;
        }
    }
    public int minCostConnectPoints(int[][] points) {

        int n = points.length ;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((n1,n2) -> n1[0] - n2[0]) ;

        for(int i = 0 ; i<n ; i++){
            for(int j = i+1 ; j<n ;j++){
                int weight = calculate_weight(points[i],points[j]) ;
                minHeap.add(new int[]{weight,i,j}) ;
            }
        }

        UnionFind uf = new UnionFind(n) ;

        HashSet<Integer> hash = new HashSet<>() ;
        int cost = 0 ;

        while(hash.size() < n){
            int[] curr = minHeap.poll() ;

            int w = curr[0], n1 = curr[1], n2 = curr[2] ;

            if(uf.unionFind(n1,n2)){
                hash.add(n1) ;
                hash.add(n2) ;

                cost += w ;
            }
        }

        return cost ;
    }

    public int calculate_weight(int[] n1, int[] n2){
        return Math.abs(n1[0] - n2[0]) + Math.abs(n1[1]-n2[1]) ;
    }
}
