import java.util.*;
public class programmers_42842 {
    /*
     * 프로그래머스 42842 카펫 https://programmers.co.kr/learn/courses/30/lessons/42842?language=java
     * 알고리즘: 완전탐색
     *
     * 구현 팁
     * - 문제 조건에 따른 조건식을 잘 세우면 됨. ..
     */
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {};
            int max = brown + yellow;
            int i = 3, j= 3;
            for(; i< max;i++){
                if(max%i == 0){
                    j = max/i;
                    if(((i-2)*(j-2)) == yellow){
                        break;
                    }
                }
            }
            answer = new int[]{Math.max(i,j), Math.min(i,j)};

            return answer;
        }
    }
}
