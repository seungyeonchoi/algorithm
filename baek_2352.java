import java.util.*;

public class baek_2352 {
    /*
     * 백준 2353 반도체 설계 https://www.acmicpc.net/problem/2352
     * 알고리즘: LIS(최장증가수열), 이분탐색 - lower_bound
     */
    static int n;
    static int [] port = new int[40000];
    static Scanner scan = new Scanner(System.in);
    static Vector<Integer> ans = new Vector<>();
    public static void main(String[] args) {
        n = scan.nextInt();
        for(int i=0;i<n;i++){
            port[i] = scan.nextInt();
        }
        ans.add(port[0]);
        lis();
        System.out.println(ans.size());
    }
    public static void lis(){
        for (int i = 1; i < n; i++) {
            if(port[i] > ans.lastElement()){
                ans.add(port[i]);
            }
            else{
                int idx = lower_bound(0,ans.size()-1,port[i]);
                ans.set(idx,port[i]);
            }
        }
    }
    //lower_bound: 처음으로 target이상인 수가 등장하는 index 위치
    public static int lower_bound(int start, int end, int target){
        if (start>= end) {
            return end;
        }
        int mid = (start+end)/2;
        if(ans.elementAt(mid)<target){
            return lower_bound(mid+1,end,target);
        }
        else{ //같거나 큼
            return lower_bound(start,mid,target); //mid 포함 이유: target과 같은 값이 없을 때 그것보다 큰 수들 중 가장 작은 값을 return 하기 위해
        }
    }

    //upper_bound: 처음으로 target보다 큰 수가 등장하는 index 위치
    public static int upper_bound(int start, int end , int target){
        if (start>= end) {
            return end;
        }
        int mid = (start+end)/2;
        if(ans.elementAt(mid)<=target){
            return upper_bound(mid+1,end,target);
        }
        else{ //큼
            return upper_bound(start,mid,target); //mid 포함 이유: target보다 큰 수 들 중 최솟값을 찾는 거니까, 현재까지 찾은 upper_bound idx 저장
        }
    }
}
