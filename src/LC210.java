import java.util.*;

public class LC210 {
    int numCourses ;
    HashMap<Integer, ArrayList<Integer>> hashmap ;
    int[] vis ;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //[ai,bi] -- bi depends on ai.
        this.numCourses = numCourses ;
        this.hashmap = new HashMap<>() ;
        this.vis = new int[numCourses] ;
        int[] in = new int[numCourses] ;

        Arrays.fill(vis,-1); // -1 : unvisited , 1 : visiting, 2 : visited.

        for(int[] pre : prerequisites){
            int u = pre[1] , v = pre[0] ;

            //v<--u , [v,u]

            ArrayList<Integer> list  = hashmap.getOrDefault(v,new ArrayList<>()) ;
            list.add(v) ;

            //Incase its new time addition -- insert in map :
            hashmap.put(u,list) ;
            in[v] ++ ;
        }

        Queue<Integer> q = new LinkedList<>() ;

        for(int i = 0 ; i<numCourses ; i++){
            System.out.println(i + " " + in[i] + " ") ;
            if(in[i] == 0)q.add(i) ;
            vis[i] = 1 ;
        }

        HashSet<Integer> hash = new HashSet<>() ;

        int[] res = new int[numCourses] ;
        int i = 0 ;

        while(!q.isEmpty()){
            int curr = q.poll() ;
            hash.add(curr) ;
            res[i++] = curr ;

            vis[curr] = 1 ;

            if(!hashmap.containsKey(curr))continue ;

            for(int neighbours : hashmap.get(curr)){

                System.out.println(neighbours + " ") ;
                in[neighbours] -- ;
                if(in[neighbours] == 0 && vis[neighbours]==-1){
                    q.add(neighbours) ;
                    vis[neighbours] = 1 ;
                }
            }
        }

        return hash.size() == numCourses ? res : new int[1] ;
    }
}
