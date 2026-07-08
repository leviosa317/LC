package JulySixth;

public class LC124 {
      public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }

      int g_max = Integer.MIN_VALUE ;

    int util(TreeNode root){
          if(root==null) return 0 ;

          int left = util(root.left) ;
          int right = util(root.right) ;

          int g = Math.max(root.val,root.val + Math.max(left,Math.max(right,left + right))) ;

          g_max = Math.max(g,g_max) ;

          return g ;
    }
    public int maxPathSum(TreeNode root) {
        g_max = Integer.MIN_VALUE ;

        util(root) ;

        return g_max ;
    }
}
