import java.util.PriorityQueue;

class MedianFinder {
    PriorityQueue<Integer> small ;
    PriorityQueue<Integer> large ;

    int numbers ;
    public MedianFinder() {
        small = new PriorityQueue<>((a,b)-> Integer.compare(b,a)) ;
        large = new PriorityQueue<>() ;
        numbers = 0 ;
    }

    public void addNum(int num) {
        numbers ++ ;

        if(numbers % 2 == 0){
            large.add(num) ;
        }else small.add(num) ;

        while(!large.isEmpty() && !small.isEmpty() && large.peek() < small.peek()){
            small.add(large.poll()) ;
            large.add(small.poll()) ;
        }
    }

    public double findMedian() {
        if(numbers %2 == 0) return (small.poll() + large.poll())/2 ;

        return small.poll() ;
    }
}
public class LC295 {
}
