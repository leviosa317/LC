import java.util.Stack;

public class LC173 {

    class BSTIterator {
        Stack<TreeNode> stack ;
        public BSTIterator(TreeNode root) {
            stack = new Stack<>() ;

            TreeNode curr = root ;

            while(curr != null){
                stack.push(curr) ;

                curr = curr.left ;
            }
        }

        public int next() {
            if(!hasNext()) return -1 ;

            TreeNode curr = stack.pop() ;
            TreeNode temp = curr ;

            curr = curr.right ;

            while(curr != null){
                stack.push(curr) ;

                curr = curr.left ;
            }

            return temp.val ;
        }

        public boolean hasNext() {
            return !stack.isEmpty() ;
        }
    }
}
