import java.util.*;

public class CutTree {
    /*
     * 백준 2805 나무 자르기 https://www.acmicpc.net/problem/2805
     * 알고리즘: 이분탐색
     */
    static int n, m, ans;
    static int [] tree = new int[1000000];
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i=0; i< n ;i++){
            tree[i] = scan.nextInt();
        }
        binarySearch(0,2000000000);
        System.out.println(ans);
    }
    public static void binarySearch(int start, int end){
        if(start>end) {
            return;
        }
        int mid = (start + end) /2;
        if(getTree(mid)>=m){
            ans = mid;
            binarySearch(mid+1,end);
        }
        else{
           binarySearch(start, mid-1);
        }
    }
    public static long getTree(int h){
        long sum = 0;
        for(int i=0; i<n;i++){
            if(tree[i]>h){
                sum+=tree[i]-h;
            }
        }
        return sum;
    }
}
