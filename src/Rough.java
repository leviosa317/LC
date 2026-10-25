import java.util.*;

public class Rough {

    public int coinChange(int[] coins, int amount) {
        int [][] dp = new int[coins.length+1][amount+1] ;

        int n = coins.length ;

        for(int []p : dp){
            Arrays.fill(p,Integer.MAX_VALUE);
        }

        for(int i= 0 ; i<n;  i++){
            dp[i][0] = 0 ;
        }

        for(int i = 0 ; i<coins.length ; i++){
            for(int j = 1 ; j<=amount ; j++){
                dp[i][j] = dp[i-1][j] ;

                int req = j - coins[i-1] ;

                if(dp[i][req] != Integer.MAX_VALUE){
                    dp[i][j] = Math.min(dp[i][req] + 1, dp[i][j]) ;
                }
            }
        }

        int minCoins = Integer.MAX_VALUE ;

        for(int i= 0 ; i<n ; i++){
            minCoins = Math.min(minCoins,dp[i][amount]) ;
        }

        return minCoins==Integer.MAX_VALUE ? -1 : minCoins ;
    }

    char[][] grid  ;
    int n ;
    int m ;

    void util(int i, int j){
        if(i<0 || j<0 || i>=n || j>=m)return ;

        if(grid[i][j] != '1') return ;

        grid[i][j] = '2' ;

        util(i,j+1) ;
        util(i,j-1) ;
        util(i+1,j) ;
        util(i-1,j) ;
    }
    public int numIslands(char[][] grid) {
        this.grid = grid ;
        //1 : land, 0: water

        n = grid.length ;
        m = grid[0].length ;

        int count = 0 ;

        for(int i = 0 ; i<n ; i++){
            for(int j = 0 ; j<m ; j++){
                if(grid[i][j] == '1'){
                    count++ ;

                    util(i,j) ;
                }
            }
        }

        return count ;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int n =nums.length ;
        HashMap<Integer,Integer> hash = new HashMap<>() ;

        for(int num : nums){
            hash.put(num, hash.getOrDefault(num, 0) + 1) ;
        }

        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a.get(1),b.get(1))) ;

        for(int key : hash.keySet()){
            int sz = minHeap.size() ;

            if(sz > k){
                minHeap.poll() ;
            }

            List<Integer> list  = new ArrayList<>() ;

            list.add(key) ;
            list.add(hash.get(key));
            minHeap.add(list) ;
        }

        int[] res = new int[n] ;
        int i = 0 ;
        while(!minHeap.isEmpty()){
            int j = minHeap.peek().get(0) ;
            minHeap.poll() ;

            res[i] = j ;
            i++ ;
        }

        return res ;
    }

    public int[][] merge(int[][] intervals) {
        int n = intervals.length ;

        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));

        List<List<Integer>> list = new ArrayList<>() ;
        int start = intervals[0][0] ;
        int end = intervals[0][1] ;

        for(int i = 1 ; i<n ; i++){
            if(intervals[i][0] > end){
                List<Integer> curr = new ArrayList<>() ;
                curr.add(start) ;
                curr.add(end) ;

                list.add(curr) ;

                start = intervals[i][0] ;
                end = intervals[i][1] ;
            }else{
                end = Math.max(intervals[i][1], end) ;
            }
        }

        List<Integer> curr = new ArrayList<>() ;
        curr.add(start) ;
        curr.add(end) ;

        list.add(curr) ;

        int sz = list.size() ;

        int[][] res = new int[sz][2]  ;

        for(int i = 0 ; i<sz ; i++){
            res[i][0] = list.get(i).get(0) ;
            res[i][1] = list.get(i).get(1) ;
        }

        return res ;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer,List<Integer>> out =new HashMap<>() ;

        //[ai,bi] 1.bi, then ai.

        int[] indegree = new int[numCourses] ;

        for(int[] pair : prerequisites){
            int u = pair[1] ;
            int v = pair[0] ;

            indegree[u] ++ ;
            List<Integer> o = out.getOrDefault(v,new ArrayList<>()) ;
            o.add(u) ;

            out.put(v,o) ;
        }

        Stack<Integer> st = new Stack<>() ;

        for(int i =0 ; i<numCourses ;i++){
            if(indegree[i] == 0){
                st.push(i) ;
            }
        }

        while(!st.isEmpty()){
            int curr = st.pop() ;

            List<Integer> neighbours = out.get(curr) ;
            if(neighbours == null) continue;

            for(int neighbour : neighbours){
                indegree[neighbour] -- ;

                if(indegree[neighbour]==0){
                    st.push(neighbour) ;
                }
            }
        }

        for(int i = 0 ; i<numCourses ; i++){
            if(indegree[i] != 0) return false ;
        }

        return true ;
    }

    public int[] rearrangeArray(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>() ;

        for(int num : nums){
            int x = 0 ;

            if(map.containsKey(num)){
                x = map.get(num) ;
            }

            map.put(num, x +1) ;
        }

       // PriorityQueue<List<Integer>> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.get(0))) ;

        int[] ans = new int[nums.length] ;
        int i =0;

        while(i<nums.length){
            Set<Integer> set = map.keySet() ;

            for(int key : map.keySet()){
                ans[i++] = key ;
                if(map.get(key)==1){
                    map.remove(key) ;
                }else{
                    map.put(key,map.get(key)-1) ;
                }
            }
        }

        return ans ;
    }

    public int maxEqualAdjacentPairs(int[] nums) {
        HashMap<List<Integer>,Integer> hash = new HashMap<>() ;
        for(int i = 0 ; i<nums.length-1 ; i++){
            int a = nums[i], b = nums[i+1] ;

            if(hash.containsKey(Arrays.asList(a,b))){
                hash.put(Arrays.asList(a,b),hash.get(Arrays.asList(a,b)) + 1) ;
            }else if(hash.containsKey(Arrays.asList(b,a))){
                hash.put(Arrays.asList(b,a),hash.get(Arrays.asList(b,a)) + 1) ;
            }else{
                hash.put(Arrays.asList(a,b),1) ;
            }
        }

        int h = 0 ;

        for(List<Integer> a : hash.keySet()){
            h = Math.max(hash.get(a), h) ;
        }

        return h ;
    }

    public int maxSubarray(int[] nums) {
        HashMap<Integer,Integer> hash = new HashMap<>() ;
        int l = 0  ; int len =0 ;

        for(int r = 0 ; r < nums.length ;r++){
            int num = nums[r] ;

//            List<Integer> ar = new ArrayList<>() ;

            if(r<2){
                len =Math.max(len, r-l+1) ;
                hash.put(num, r) ;
                continue;
            }

            for(int j = l ; j<r ; j++){
                int xk = nums[r] ;

                int xj = nums[j] ;

                int xi = xk-xj ;

                if(hash.containsKey(xi) && hash.get(xi) >= l){
                    l = hash.get(xi) + 1;
                }
            }

            len = Math.max(len, r-l+1) ;

            hash.put(num, r) ;
        }

        return len ;

    }

//    public long maxEarnings(int[][] meetings) {
//
//    }
}
