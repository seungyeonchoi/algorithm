import java.util.*;
public class programmers_42746 {
    /*
     * 프로그래머스 42746 큰 수 찾기 https://programmers.co.kr/learn/courses/30/lessons/42746?language=java
     * 알고리즘: 정렬 (1)List+ sort (2) sort를 정의한 priority queue
     *
     * 구현 팁
     * 1. 람다함수 sort를 만들 때 new Comparator<T>()를 이용했는데, ((T o1 ,T o2)->{return (int)}) 로 구현 가능
     * 아이디어
     * 1. 정렬 기준
     * 두 수(a,b)에 대해 "\(a)\(b)" 와 "\(b)\(a)" 대소 비교 후 더 큰 수가 나오게 정렬
     * 2. 이때 일반 리스틀르 쓰면, sort해주고, PQ 만들어 sort기준을 정의해주는 방법도 있음
     *
     */

    class Solution {
        public String solution(int[] numbers) {
            String answer = "";
            PriorityQueue<String> pq = new PriorityQueue<String>((a,b)-> {
                return (b+a).compareTo(a+b);
            });
            for (int num : numbers) {
                pq.offer(String.valueOf(num));
            }

            while (!pq.isEmpty()) {
                answer += pq.poll();
            }

            if (answer.charAt(0) == '0')
                return "0";
            return answer;
        }
    }
}
