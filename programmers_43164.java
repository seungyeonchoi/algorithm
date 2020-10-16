import java.util.*;
public class programmers_43164 {
    /*
     * 프로그래머스 43164 여행경 https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
     * 알고리즘: 완전탐색 - dfs(백트래킹)
     * 구현 팁
     * 1. 방문 여부 확인
     * (방법 1) visited 배열 선언
     * (방법 2) (문제에 따라 다르지만)주어진 데이터를 모두 활용해야 하는 문제라면, tmp.contains(~) 이용
     */
    class Solution {
        Vector<String[]> v = new Vector<>();

        public String[] solution(String[][] tickets) {
            String[] answer = {};
            dfs("ICN",new Vector<Integer>(), tickets);
            // System.out.println(v.size());
            // for(String[] vv: v){
            //     for(String i: vv){
            //         System.out.print(i+" ");
            //     }
            //     System.out.println();
            // }
            Collections.sort(v,(a,b)->{
                for(int i = 0; i< a.length;i++){
                    if(!a[i].equals(b[i])){
                        return a[i].compareTo(b[i]);
                    }
                }
                return 0;
            });
            answer = v.get(0);
            return answer;
        }

        void dfs(String from, Vector<Integer> tmp, String[][] tickets){
            if(tmp.size() == tickets.length){
                //v.add(tmp); =>tmp 날라가면 다 날라감
                //v.add(new Vector<Integer>(tmp)); => 이렇게 따로 또 만들어서 넣어줘야함
                String[] str = new String[tmp.size()+1];
                for(int i =0;i<tmp.size();i++){
                    str[i] = tickets[tmp.get(i)][0];
                }
                str[tmp.size()] = tickets[tmp.lastElement()][1];
                v.add(str);
                return;
            }
            for(int i = 0; i<tickets.length;i++){
                if(tmp.contains(i)) continue;
                if(tickets[i][0].equals(from)){
                    tmp.add(i);
                    dfs(tickets[i][1], tmp, tickets);
                    tmp.remove(tmp.size()-1);
                }
            }
        }
    }
}
