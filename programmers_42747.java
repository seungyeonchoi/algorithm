import java.util.*;
public class programmers_42747 {
    /*
     * 프로그래머스 42747 H-Index  https://programmers.co.kr/learn/courses/30/lessons/42747?language=java
     * 자료구조: 이분탐색
     *
     */
    class Solution {
        int answer = 0;
        public int solution(int[] citations) {
            Arrays.sort(citations);
            bs(citations,0,citations.length);
            return answer;
        }
        int check(int[] citations, int target){
            int sum = 0;
            for(int i : citations) {
                sum += i >= target ? 1 : 0;
            }
            return sum;
        }
        void bs(int[] citations, int start, int end){
            if(start>end) return;
            int mid = (start+end)/2;
            if(check(citations, mid)>=mid){
                answer = mid;
                bs(citations,mid+1,end);
            }
            else{
                bs(citations,start,mid-1);
            }
        }
    }
}
