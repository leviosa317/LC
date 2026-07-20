import java.util.ArrayList;
import java.util.List;

public class LC23 {
    
     public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null || lists.length==0){
            return null ;
        }

        while(lists.length > 1){
            List<ListNode> mergedList = new ArrayList<>() ;
            for(int i = 0 ; i <lists.length ; i= i + 2){
                ListNode l1 = lists[i] ;
                ListNode l2 = (i+1) < lists.length ? lists[i+1] : null ;

                mergedList.add(mergeLists(l1,l2)) ;
            }
            lists = mergedList.toArray(new ListNode[0]) ;
        }

        return lists[0] ;
    }

    public ListNode mergeLists(ListNode l1, ListNode l2){
         ListNode dummy = new ListNode() ;
         ListNode tail = dummy ;

         while(l1 != null && l2 != null){
             if(l1.val < l2.val){
                 tail.next = l1 ;
                 l1 = l1.next ;
                 tail = tail.next ;
             }else{
                 tail.next = l2 ;
                 l2 = l2.next ;
                 tail = tail.next ;
             }
         }

         if(l1 != null){
             tail.next = l1 ;
         }else{
             tail.next = l2 ;
         }

         return dummy.next ;
    }
}
