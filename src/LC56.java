import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC56 {

    public int[][] merge(int[][] intervals) {

        int m = intervals.length ;

        List<List<Integer>> res = new ArrayList<>() ;
//
//        Arrays.sort(intervals, (a,b) -> {
//            if(a[0] != b[0]){
//                return a[0] - b[0];
//            }else return a[1] - b[1] ;
//        }) ;

        int start = intervals[0][0] ;
        int end = intervals[0][1] ;

        for(int i = 1 ; i<m ; i++){
            int[] curr = intervals[i] ;
            if(end < curr[0]){
                res.add(Arrays.asList(start,end)) ;

                start = curr[0] ;
                end = curr[1] ;
            }else{
                end = Math.max(end, curr[1]) ;
            }
        }

        res.add(Arrays.asList(start,end)) ;

        int [][] d = new int[res.size()][2] ;

        int i =0 ;

        for(List<Integer> p : res){
            d[i] = new int[]{p.get(0), p.get(1)} ;

            i++ ;
        }

        return d ;
    }

    public static void main(String args[]){
        int[][] a = new int[][]{{1,3},{6,9}} ;
        insert(a, new int[]{3,5}) ;
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
//
//        int start = intervals[0][0] ;
//        int end = intervals[0][1] ;


        int m = intervals.length ;


        List<List<Integer>> res = new ArrayList<>() ;
//        int i = 0 ;

        int target = newInterval[0] ;
        int l = 0, r = m-1 ;

        int ff = 0 ;

        while(l<=r){
            int mid = (l+r)/2 ;

            int aM = intervals[mid][0] ;



            if(aM > target){
                ff = mid ;
                r = mid - 1 ;
            }else{
                //aM <= target
                l = mid + 1 ;
            }
        }

        int j = 0 ;

        for(int i =0  ; i<m ; i++){

            if(j==ff){
                res.add(Arrays.asList(newInterval[0],newInterval[1])) ;
                j++ ;
            }

            res.add(Arrays.asList(intervals[i][0],intervals[i][1])) ;
            j++ ;
        }

        int start = res.get(0).get(0) ;
        int end = res.get(0).get(1) ;

        List<List<Integer>> result = new ArrayList<>() ;

        for(int i = 1 ; i< res.size() ; i++){
            List<Integer> curr = res.get(i) ;
            if(end < curr.get(0)){
                result.add(Arrays.asList(start,end)) ;

                start = curr.get(0) ;
                end = curr.get(1) ;
            }else{
                end = Math.max(end, curr.get(1)) ;
            }
        }

        result.add(Arrays.asList(start,end)) ;

        int [][] d = new int[result.size()][2] ;

        int i =0 ;

        for(List<Integer> p : result){
            d[i] = new int[]{p.get(0), p.get(1)} ;

            i++ ;
        }

        return d ;
    }

    public int minMeetingRooms(List<Interval> intervals) {
        int start =0  , end = 0 ;

        for(int i =0 ; i<intervals.size() ; i++){
            start = Math.min(intervals.get(i).start, start) ;
            end = Math.max(intervals.get(i).end, end) ;
        }

        int[] rooms = new int[end+1] ;

        for(int i =0 ; i<intervals.size() ; i++){
            rooms[intervals.get(i).start] ++ ;
            rooms[intervals.get(i).end] -- ;
        }

        int r =1 ;
        int sum =0 ;

        for(int i = 0 ; i<=end ; i++){
            sum += rooms[i] ;

            r = Math.max(r, sum) ;
        }

        return r ;
    }

    public class Interval {
       public int start, end;
       public Interval(int start, int end) {
           this.start = start;
           this.end = end;
       }
   }
}
