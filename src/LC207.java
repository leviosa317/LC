import java.util.*;

public class LC207 {
    int numCourses ;
    HashMap<Integer, ArrayList<Integer>> hashmap ;
    int[] vis ;
    boolean detectAcyclicGraph(int i){
         if(vis[i] == 1) return false ;
         if(vis[i] == 2) return true ;

         vis[i] = 1 ;

         if(hashmap.containsKey(i)){
             ArrayList<Integer> list = hashmap.get(i) ;

             for(int neighbour : list){
                 if(!detectAcyclicGraph(neighbour)) return false ;
             }
         }

         vis[i] = 2 ;
         return true ;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //[ai,bi] -- bi depends on ai.
        this.numCourses = numCourses ;
        this.hashmap = new HashMap<>() ;
        this.vis = new int[numCourses] ;

        Arrays.fill(vis,-1); // -1 : unvisited , 1 : visiting, 2 : visited.

        for(int[] pre : prerequisites){
            int u = pre[1] , v = pre[0] ;

            ArrayList<Integer> list  = hashmap.getOrDefault(v,new ArrayList<>()) ;
            list.add(u) ;

            //Incase its new time addition -- insert in map :
            hashmap.put(v,list) ;
        }

        for(int i = 0 ; i<numCourses ; i++){
            if(vis[i] == -1){
                if(!detectAcyclicGraph(i))return false ;
            }
        }

        return true ;

    }
}
