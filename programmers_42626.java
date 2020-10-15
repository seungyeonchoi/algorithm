import java.util.*;

public class programmers_42626 {
    /*
     * 프로그래머스 42626 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42626?language=java
     * 알고리즘: 우선순위큐
     *
     */
    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;
            PriorityQueue<Integer> pq = new PriorityQueue<>(); //오름차순
            for(int i: scoville){
                pq.add(i);
            }
            while(pq.peek()<K && pq.size()>=2){
                int a = pq.poll();
                int b = pq.poll();
                int s = a + 2*b;
                pq.add(s);
                answer++;
            }
            if(pq.peek()<K && answer== scoville.length-1 ) return -1;
            return answer;
        }
    }
}
