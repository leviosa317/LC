package JulySixth;

public class LC74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0 ; int m = matrix.length ; int n = matrix[0].length ;

        int j = m*n - 1 ;

        int total = m*n ;

        while(i<j){
            int mid = (i+j)/2 ;

            int m_i = total/j ;
            int m_j = total %j ;

            int aM = matrix[m_i][m_j] ;

            if(aM == target) return true ;

            if(aM > target){
                j = mid - 1 ;
            }else {
                i = mid + 1 ;
            }
        }

        return false ;
    }
}
