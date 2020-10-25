import java.util.Collections;
import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class baek_1662 {
    /*
     * 백준 1662 창고 다각형 https://www.acmicpc.net/problem/1662
     * 알고리즘: 재귀
     *
     * 시도
     * (1) stack을 이용해 문자열을 그대로 보존하려하니 메모리 초과 -> () 안에 들어있는 문자의 갯수를 다시 stack에 넣는 방법도 있음
     * (이때, 원래 문자열과 갯수를 넣은 건 따로 구분이 필요)
     * (2) 재귀 함수를 이용해 괄호 안에 들어있는 문자의 갯수 세기
     */
    static Scanner scan = new Scanner(System.in);
    static char[] str;
    static boolean[] visited = new boolean[50]; //이미 검사했는지 체크
    public static void main(String[] args) {
        str = scan.nextLine().toCharArray();
        System.out.println(getCount(0,str.length));
    }
    static int getCount(int start, int end){
        int count = 0;
        for(int i = start; i<end;i++){
            if(visited[i] == false) {
                visited[i] = true;
                if (str[i] == ')') { //')'를 만날 때 까지의 문자 갯수 return
                    return count;
                } else if (str[i] == '(') { //'('를 만나면, 그 이후 index에 () 꼴이 없을 때 까지 재귀
                    count += getCount(i + 1, end) * (str[i - 1] - '0') - 1;
                } else { //일반 문자일 경우 count++
                    count++;
                }
            }
        }
        return count;
    }
}
