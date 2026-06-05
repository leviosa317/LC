import java.sql.Array;
import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.MAX_VALUE;
import static java.util.Collections.*;

public class Main {
    public static void main(String[] args) {

        leetcode l = new leetcode() ;

        int[][] nums = {{2,4},{3,2},{4,1},{6,4},{12,4}};
        int k = 8 ;

        l.maximumSaleItems(nums, 8) ;
    }
}
