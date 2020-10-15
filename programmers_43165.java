import java.util.*;
public class programmers_43165 {
    /*
     * 프로그래머스 43165 타겟 넘버 https://programmers.co.kr/learn/courses/30/lessons/43165?language=java
     * 알고리즘: 완전탐색 - DFS
     *
     * 재귀를 이용한 dfs 팁
     * (1) 완료 조건 만들기 -> 여기서는 나열된 연산자의 갯수
     * (2) 같은 round에서 시도해볼 경우의 수를 전체 for문으로 만들기
     * ex. 여기서는 한 칸에 + or - 가 들어갈 수 있음 -> 반복횟수가 총 2번이 됨 한 칸에 + 쫘르르륵 넣어보고, 하나씩 빼면서 - 넣기!
     */
    class Solution {
        int[] op = new int[]{0,1}; //0: 덧셈, 1: 뺄셈
        int answer = 0;
        public int solution(int[] numbers, int target) {
            dfs(numbers, new Vector<Integer>(), target, numbers.length);
            return answer;
        }
        boolean check(int[] numbers, Vector<Integer> tmp, int target){//정답체크
            int sum = 0;
            for(int i = 0; i<numbers.length;i++){
                sum+= tmp.elementAt(i) == 0 ? numbers[i] : -numbers[i];
            }
            return sum == target;
        }
        void dfs(int[] numbers, Vector<Integer> tmp, int target, int size){
            if(tmp.size() == size){
                if(check(numbers, tmp, target)){
                    answer++;
                }
                return;
            }
            for(int i = 0; i<2;i++){
                tmp.add(op[i]);
                dfs(numbers, tmp, target, size);
                tmp.remove(tmp.size()-1);
            }

        }
    }
}
