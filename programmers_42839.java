import java.util.*;
public class programmers_42839 {
    /*
     * 프로그래머스 42839 소수 찾기  https://programmers.co.kr/learn/courses/30/lessons/42839?language=java
     * 알고리즘: 완전 탐색 (순열 - 백트래킹 + 소수판단)
     *
     * 1. 순열 구하기 - 백트래킹 이용 (더 간단한 방법이 있늗네 . . . .일단 공부한 거 복습!)
     * - [1,1,0] 처럼 중복된 수 있음->  visited 배열을 선언하여 기존에 넣었던 숫자는 또 안넣게 처리함
     * - 무조건 중복된 수 없다 -> 그럼 그냥 tmp에 현재 숫자 i가 포함되어있는지 확인하면 됨
     */
    class Solution {
        Vector<String> v = new Vector<>();
        boolean[] visited = new boolean[7];
        public int solution(String numbers) {
            int answer = 0;
            char [] arr = numbers.toCharArray();
            for(int i =1; i<= numbers.length();i++){
                backtracking(arr,new String(),i);
            }
            for(String str: v){
                if(isPrime(Integer.parseInt(str))){
                    answer++;
                }
            }

            return answer;
        }
        public void backtracking(char [] arr, String tmp, int size){
            if(tmp.length()==size){
                if(v.contains(tmp)) return;
                if(!(tmp.toCharArray()[0] == '0')){ //011 == 11
                    v.add(tmp);
                    //System.out.println(tmp);
                }
                return;
            }
            for(int i = 0;i< arr.length; i++){
                if(visited[i]) continue;
                tmp+=arr[i];
                visited[i] = true;
                backtracking(arr, tmp, size);
                tmp = tmp.substring(0, tmp.length()-1);
                visited[i] = false;
            }

        }
        public boolean isPrime(int num) {

            if(num == 1) return false;
            for(int i = 2; i<num;i++){
                if((num % i) == 0) return false;
            }
            return true;
        }
        // boolean isPrime(int n) {
        // 	int i;
        // 	int sqrt = (int) Math.sqrt(n);
        // 	// 2는 유일한 짝수 소수
        // 	if (n == 2)
        // 		return true;
        // 	// 짝수와 1은 소수가 아님
        // 	if (n % 2 == 0 || n == 1)
        // 		return false;
        // 	// 제곱근까지만 홀수로 나눠보면 됨
        // 	for (i = 3; i <= sqrt; i += 2) {
        // 		if (n % i == 0)
        // 			return false;
        // 	}
        // 	return true;
        // }
    }
}
