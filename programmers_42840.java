import java.util.*;

public class programmers_42840 {
    /*
     * 프로그래머스 42840 모의고사 https://programmers.co.kr/learn/courses/30/lessons/42840?language=java
     * 알고리즘: 완전탐색
     *
     * 어려웠던 점
     * output 조건이 int[]인데 처음에 int[] answer = {}이 당연히 초기화 되어있는 건 줄 알았다. . . ..아니다. . .count로 생성해줘야함 ...!!!!
     *
     */
    class Solution {
        public int[] solution(int[] answers) {
            int[] answer = {};
            int [][] num = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
            int [] solve = new int[3];
            //수포자별 문제 맞은 갯수 세기
            for(int i=0;i<answers.length;i++){
                for(int j =0;j<3;j++){
                    if(answers[i]==num[j] [i%(num[j].length)])
                        solve[j]++;
                }
            }
            //최대 정답자의 정답 갯수와 인원 구하기
            int max = solve[0];
            int count = 1;
            for(int i =1;i<3;i++){
                if(max<solve[i]){
                    count =1;
                    max = solve[i];
                }
                else if(max == solve[i]){
                    count++;
                }
            }
            //output 만들기
            answer = new int[count];
            count =0;
            for(int i =0;i<3;i++){
                if(solve[i] == max){
                    answer[count++]=i+1;
                }
            }

            return answer;
        }
    }
}
