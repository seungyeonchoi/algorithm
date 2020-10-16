import java.util.*;
public class programmers_42748 {

    /*
     * 프로그래머스 42748 k번째 수 https://www.acmicpc.net/problem/1300
     * 알고리즘: 정렬
     *
     * 팁
     * 1. Arrays.copyOfRange(T[], int from ,int to)
     */
    class Solution {
        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];

            for(int i = 0; i<commands.length;i++){
                int[] arr = Arrays.copyOfRange(array, commands[i][0]-1,commands[i][1]);
                Arrays.sort(arr);
                answer[i] = arr[commands[i][2]-1];
            }
            return answer;
        }
    }
}
