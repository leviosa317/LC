package SegmentTree;

import java.util.Arrays;

public class LC406 {

    public static void main(String[] args) {
        int[][] peeps = new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}} ;

        reconstructQueue(peeps) ;
    }
    public static int[][] reconstructQueue(int[][] people) {
        //Sort with height descending , k ascending.

        int n = people.length; ;

        Arrays.sort(people, (a,b) -> {
            if(a[0] != b[0]){
                return a[0] - b[0] ;
            }else return b[1] - a[1] ;
        }) ;

        int[][] res = new int[n][2] ;

        int[] slots =new int[n] ;
        Arrays.fill(slots, 1);

        SegmentTree tree = new SegmentTree(slots) ;

        for(int i = 0 ; i<n ;i++){
            int k_req = people[i][1] + 1;

            int l = 0 , r = n-1 ;
            int idx = -1 ;

            while(l<r){
                int mid = l +(r-l)/2 ;

                int cnt = (int) tree.query(l,mid);

//                if(cnt==k_req)

                if(cnt  < k_req){
                    l = mid + 1 ;
                    k_req = k_req - cnt ;
                }else{
                    //cnt >= k_req.
                    r = mid ;
                }
            }

            tree.update(r,0);

            res[r] = people[i] ;
        }

        return res ;
    }

    public static class SegmentTree {
        int n;
        long[] tree;

        // CORE LOGIC 1: Identity value
        long identity() {
            return 0L; // SUM: 0, MIN: Long.MAX_VALUE
        }

        // CORE LOGIC 2: How to combine two children
        long merge(long left, long right) {
            return left + right; // SUM
        }

        SegmentTree(int[] a) {
            n = a.length;
            tree = new long[4 * n];
            build(1, 0, n - 1, a);
        }

        void build(int node, int start, int end, int[] a) {
            if (start == end) {
                tree[node] = a[start];
                return;
            }

            int mid = (start + end) / 2;
            build(node * 2, start, mid, a);
            build(node * 2 + 1, mid + 1, end, a);

            tree[node] = merge(
                    tree[node * 2],
                    tree[node * 2 + 1]
            );
        }

        void update(int node, int start, int end,
                    int idx, long value) {
            if (start == end) {
                tree[node] = value;
                return;
            }

            int mid = (start + end) / 2;

            if (idx <= mid) {
                update(node * 2, start, mid, idx, value);
            } else {
                update(node * 2 + 1, mid + 1, end, idx, value);
            }

            tree[node] = merge(
                    tree[node * 2],
                    tree[node * 2 + 1]
            );
        }

        long query(int node, int start, int end, int l, int r) {
            // No overlap
            if (r < start || end < l) {
                return identity();
            }

            // Complete overlap
            if (l <= start && end <= r) {
                return tree[node];
            }

            // Partial overlap
            int mid = (start + end) / 2;

            long left = query(node * 2, start, mid, l, r);
            long right = query(node * 2 + 1, mid + 1, end, l, r);

            return merge(left, right);
        }

        // Wrappers: leave these alone
        void update(int idx, long value) {
            update(1, 0, n - 1, idx, value);
        }

        long query(int l, int r) {
            return query(1, 0, n - 1, l, r);
        }
    }

}
