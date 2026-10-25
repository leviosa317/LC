import java.util.HashMap;
import java.util.Stack;

public class LC2267 {

    int[][] dp ;
    int m ;

    int n ;

    char[][] grid ;

    boolean solve(int i, int j, int  curr){
        if(i >=m || j>=n)return false ;

        curr = curr + grid[i][j] == '(' ? 1 : -1 ;

        if(i==m-1 && j==n-1){
            if(curr == 0)return true ;

            return  false ;
        }

        boolean side = solve(i,j+1,curr) ;
        boolean down = solve(i+1,j,curr) ;

        return side || down ;

    }

    public boolean hasValidPath(char[][] grid) {
        this.grid = grid ;
        m = grid.length ;
        n = grid[0].length ;
        dp = new int[m][n] ;

        return solve(0,0,0) ;
    }
}
