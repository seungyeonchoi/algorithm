import java.util.*;

public class kthNumber {
    /*
     * 백준 1300 k번째 수 https://www.acmicpc.net/problem/1300
     * 알고리즘: 이분탐색, 아이디어도 중요함
     * try1:  upper_bound를 찾아 -1한 위치에 데이터 추가 ->(정렬된 상태이니)b[k]접근  => 시간초과
     * 주요 아이디어
     * 1) k번째 수는 k보다 크지 않음 -> 즉, 1 ~ k 가 답이 될 수 있는 데 조건을 만족하는 최솟값을 찾으면 됨
     * 2) 여기서 조건이란 k번째 수 -> k번째가 되려면 앞에 k-1개의 숫자가 있어야함
     */
    static int n,k,ans;
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        n = scan.nextInt();
        k = scan.nextInt();
        binarysearch(1,k);
        System.out.println(ans);
    }
    public static int getCount(int mid){
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum+=Math.min(mid/i,n);
        }
        return sum;
    }
    public static void binarysearch(int start, int end){
        if(start>end) return;
        int mid = (start+end)/2;
        if(getCount(mid)>=k){
            ans = mid;
            binarysearch(start,mid-1);
        }
        else{
            binarysearch(mid+1,end);
        }
    }
}
