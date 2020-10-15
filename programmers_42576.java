import java.util.*;
public class programmers_42576 {
    /*
     * 프로그래머스 42576 완주하지 못한 선수 https://programmers.co.kr/learn/courses/30/lessons/42576?language=java
     * 알고리즘: 해쉬
     *
     * 구현 팁
     * 1. HashTable 이용
     * - getOrDefault(V): 이미 존재하는 key이면 해당하는 value, 없으면 Default값 반환됨
     */
    class Solution {
        public String solution(String[] participant, String[] completion) {
            String answer = "";
            Hashtable<String,Integer> d = new Hashtable<>();
            for(String name: participant){
                // if(d.containsKey(name)){
                //     int count = d.get(name);
                //     d.put(name,count+1);
                // }
                // else{
                //     d.put(name,0);
                // }
                d.put(name, d.getOrDefault(name,0)+1);
            }
            // for (Enumeration<Integer> e = d.elements() ; e.hasMoreElements();){
            //     answer+= e.nextElement();
            // }
            for(String name: completion){
                // int count = d.get(name);
                // if(count == 0){
                //     d.remove(name);
                // }
                // else{
                //      d.put(name, --count);
                // }
                d.put(name,d.get(name)-1);
            }
            // for (Enumeration<String> e = d.keys() ; e.hasMoreElements();){
            //     answer+= e.nextElement();
            // }
            for (String key : d.keySet()) {
                if (d.get(key) != 0){
                    answer = key;
                    break;
                }
            }
            return answer;
        }
    }
}
