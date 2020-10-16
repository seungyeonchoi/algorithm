import java.util.*;
public class programmers_42577 {
    /*
     * 프로그래머스 42577 전화번호 목록 https://programmers.co.kr/learn/courses/30/lessons/43164?language=java
     * 알고리즘:
     *
     * 팁
     * 1. string.startswith(string ~) : 접미사 판단 시 사용
     */
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            HashMap<String,String> map = new HashMap<>();
            Arrays.sort(phone_book, (a,b)->{
                return a.length() - b.length();
            });
            for(int i =0; i< phone_book.length-1;i++){
                for(int j = i+1; j< phone_book.length;j++){
                    if(phone_book[j].startsWith(phone_book[i])){
                        return false;
                    }
                }
            }
            return answer;
        }
    }
}
