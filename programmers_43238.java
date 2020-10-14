import java.util.*;
public class programmers_43238 {
    /*
     * 프로그래머스 43238 입국심사 https://programmers.co.kr/learn/courses/30/lessons/43238?language=java
     * 알고리즘: 이분탐색, 아이디어도 중요함
     *
     * - 이분탐색 조건
     * 1. sort된 배열에서 수행 -> index가 커감에 따라 연산값이 일정하게 증가하거나 감소해야함
     * -> 이번 문제에서는 1 ~ 최대 수행가능 시간을 이분탐색 함 -> 시간이 커질 수록 처리가능인원이 늘어남
     * 2. check함수: mid 시간 내에 처리 가능한 인원이 기준 인원(n) 이상인지 체크
     * -> 입국심사는 각 심사관이 독립적으로 가능하므로, 심사관마다 mid 시간 내에 처리할 수 있는 인원수를 계산하여 n과 비교
     * 3. if(start>end) 조건 은 mid -1, mid+1 로 재귀짬
     * 만약, lower_boud, upper_bound 같은 경우엔 if(start>=end)로하고 mid+1, mid로 처리함(이유는 k_th number 참고)
     */

    static class Solution {
        long answer = 0;
        public long solution(int n, int[] times) {
            if(n<times.length){
                answer = times[n-1];
            }
            else{
                answer = (long)times[times.length-1]*(long)n;
                binarysearch(n, times, 1, answer);
            }
            return answer;
        }
        public void binarysearch(int n, int[] times, long start, long end){
            if(start>end) return;
            long mid = (start+end)/2;
            if(check(n,times,mid)){
                answer = Math.min(answer,mid);
                binarysearch(n,times, start, mid-1);
            }
            else{
                binarysearch(n, times, mid+1, end);
            }
        }
        public boolean check(int n, int[] times, long mid){
            long sum = 0;
            for(int i: times){
                sum+= mid/i;
            }
            if(sum>=n)
                return true;
            else
                return false;
        }
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(3, new int[]{1000000000, 1000000000,1000000000}));
    }

}
