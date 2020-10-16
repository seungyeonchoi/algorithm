import java.util.*;
public class programmers_43163 {
    /*
     * 프로그래머스 43163 단어변환 https://programmers.co.kr/learn/courses/30/lessons/43163?language=java
     * 알고리즘: 완전탐색 - dfs(백트래킹)
     *
     * 구현 팁
     * 1. 완료조건 설정
     * 2. 재귀 설정
     * (1) 처음엔 begin 변수를 word[i]로 계속 바꿔가며 대입했음 -> 발생한 문제: 모든 단어에 대해 모든 경우의수를 체크해야하는데, begin = words[i] 가 되어버리면, 좌항이 바뀌어 버림 -> 모든 경우의 수 비교 못함!
     */
    class Solution {
        boolean[] visited = new boolean[50];
        int answer = 51; //최대 횟수 51번
        public int solution(String begin, String target, String[] words) {
            dfs(begin, target,words,0);
            if(answer==51) return 0;
            return answer;
        }
        boolean check(char[] a, char[] b){
            int cnt = 0;
            for(int i =0 ;i<a.length;i++){
                if(a[i]==b[i]) cnt++;
            }
            return cnt == a.length-1;
        }
        void dfs(String begin, String target, String[] words,int count){
            if(begin.equals(target)){
                answer = Math.min(answer,count);
                return;
            }
            for(int i = 0 ; i< words.length; i++){
                if(visited[i]) continue; //이미 방문한 단어는 건너 뜀
                visited[i] = true;
                if(check(begin.toCharArray(),words[i].toCharArray())){
                    dfs(words[i],target, words,count+1);
                }
                //else는 필요 없음 -> 어차피 변환할 수 없기 때문에 정답이 못 됨
                // else{
                //     dfs(begin,target, words,count);
                // }
                visited[i] = false;
            }
        }
    }
}
