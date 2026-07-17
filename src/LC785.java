public class LC785 {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length ;

        int[][] adj = new int[n][n] ;

        for(int u = 0 ; u<n ; u++){
            for(int v : graph[u]){
                adj[u][v] = 1 ;
            }
        }

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<graph[i].length ; j++){
                for(int k = j+1 ; k<graph[i].length ; k++){
                    if(adj[j][k] > 0) return false ;
                }
            }
        }

        return true ;
    }
}
