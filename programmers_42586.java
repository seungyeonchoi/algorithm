import java.util.*;

class Solution {
    /*
     * 프로그래머스 42586 기능개발 https://programmers.co.kr/learn/courses/30/lessons/42586?language=java
     * 자료구조: 큐
     * 문제 특징: 
        (1) 각 작업마다 배포까지 필요한 날짜를 구하고,
        (2) 각 작업이 배포될 때 함께 배포될 수 있는 작업의 수 구하기
     */
    public Vector<Integer> solution(int[] progresses, int[] speeds) {
        Vector<Integer> answer = new Vector<>();
        
        Queue<Integer> q = new LinkedList<Integer>();
        //각 작업마다 완료까지 필요한 날짜 계산
        for(int i = 0; i< progresses.length; i++){
            double rest = 100.0 - progresses[i];
            q.offer((int)Math.ceil(rest/speeds[i])); //올림-> 2.7일이 걸리면 적어도 3일 후에 배포가 가능
        }
        //작업이 배포될 때, 함께 배포될 수 있는 작업의 갯수 구하기
        while(!q.isEmpty()){
            int count = 1;
            int top = q.poll();
            //함께 배포될 수 있는 작업의 갯수 구하기
            while(!q.isEmpty() && q.peek()<= top){
                count++;
                q.poll();
            }
            answer.add(count);
        }
        return answer;
    }
}