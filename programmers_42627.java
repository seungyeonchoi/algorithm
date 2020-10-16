import java.util.*;
public class programmers_42627 {

    /*
     * 프로그래머스 42627 디스크 컨트롤러 https://programmers.co.kr/learn/courses/30/lessons/42627?language=java
     * sjf 알고리즘 구현
     * 자료구조: 우선순위큐
     *
     * try1: pq를 두 개 만들어서 해결하려함 (1) job [0]정보, (2) 같이 시작했을 때 언제 끝나는지 정보
     * -> (1)은 pq로 안하고 array로 정렬 후 계속 재사용 가능
     */
    class Solution {
        // class data{
        //     int start; //시작시간
        //     int time;  //걸리는 시간
        //     public data(int i, int j){
        //         this.start = i;
        //         this.time = j;
        //     }
        // }
        public int solution(int[][] jobs) {
            int answer = 0;
            Arrays.sort(jobs, (a,b)->{
                return a[0] - b[0]; //요청 시간 기준 오름차순
            });
            PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)->{
                return a[1]-b[1]; //작업 시간 기준 오름차순 -> 시작시간을 고려안해도 되는 이유: 같은 라운드에서 비교되는 Job들은 결국 동일한 시간에 시작함 -> 작업시간이 빨리끝나는게 젤 먼저 시작되어야함
            });
            int end = 0;
            int idx = 0 ;
            int len = jobs.length;
            while(idx< len || !pq2.isEmpty()){
                for( ;idx<len;idx++){
                    if(jobs[idx][0]<=end){
                        pq2.offer(jobs[idx]); //end시간 기준 수행할 수 있는 모든 job을 pq에 offer
                    }
                    else{
                        break;
                    }
                }
                if(pq2.isEmpty()){ //end시간 기준 실행할 수 있는 작업이 없을 경우
                    end = jobs[idx][0];
                }else{
                    int[] a = pq2.poll();
                    end += a[1];
                    answer += end - a[0];
                }
            }
            answer/= jobs.length;
            return answer;
        }
    }
}
