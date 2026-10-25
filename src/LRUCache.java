import java.util.HashMap;

public class LRUCache {
    public class DLL {
        int val ;
        DLL prev ;

        DLL next ;

        public DLL(int val){
            this.val = val ;
        }
    }

    HashMap<Integer,DLL> hash ;
    DLL head ;
    DLL tail ;

    int capacity ;

    public LRUCache(int capacity) {
        hash = new HashMap<>() ;
        this.capacity = capacity ;
    }

    public int get(int key) {
        if(hash.containsKey(key)){

            return hash.get(key).val ;
        }

        return -1 ;
    }

//    public void remove(DLL node){
//        //head
//        if(head == node){
//            head.next =
//        }
//
//        //tail
//
//        //middle element
//    }

    public void putNodeInHead(DLL node){
        head.prev = node ;
        node.next = head ;

        head = node ;
    }

    public void put(int key, int value) {

        if(hash.size() == capacity){
            //evict tail
            tail = tail.prev ;

            DLL node = new DLL(value) ;

            if(tail == null){
                head = node ;
                tail = node ;
            }else{
                tail.next = null ;
                head.prev = node ;
                node.next = head ;
                head = node ;
            }
        }else{
            DLL node = new DLL(value) ;

            if(head != null){
                head.prev = node ;
            }else{
                tail = node ;
            }
            node.next = head ;
            head = node ;
            hash.put(key,node) ;
        }
    }
}
