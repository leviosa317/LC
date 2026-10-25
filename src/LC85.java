import java.util.Stack;

public class LC85 {

    public int maximalRectangle(char[][] matrix) {

        int n = matrix.length ;
        int m = matrix[0].length ;

        int[][] grid = new int[n][m] ;

        int maxArea = 0 ;



        for(int i = 0 ; i<n ; i++){
            Stack<Integer> st = new Stack<>() ;
            for(int j = 0 ; j<m ; j++){

                grid[i][j] = matrix[i][j] - '0' ;
                if(i > 0 && grid[i][j] == 1){
                    grid[i][j] = grid[i-1][j] + 1 ;
                }

                maxArea = Math.max(maxArea, findMaxArea(grid[i])) ;
            }
        }

        return maxArea ;
    }

    int findMaxArea(int[] rectangles){

        Stack<Integer> st = new Stack<>() ;

        int maxArea = 0 ;

        for(int i = 0 ; i<rectangles.length ; i++){

            while(!st.isEmpty() && rectangles[st.peek()] > rectangles[i]){

                int curr = st.pop() ;

                int left = -1 ;

                if(!st.isEmpty()){
                    left = st.peek() ;
                }

                int right = i ;

                maxArea = Math.max(maxArea, rectangles[curr]*(right - left -1)) ;
            }
        }

        return maxArea ;
    }
}
