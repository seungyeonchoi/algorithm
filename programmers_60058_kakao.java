
import java.util.Scanner;
public class programmers_60058_kakao {
    /*
     * 프로그래머스 60058 괄호 변환 https://programmers.co.kr/learn/courses/30/lessons/60058
     * 유형: 구현
     */

    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        String str = scan.nextLine();
        System.out.println(solution(str));
    }
    static String getBalence(String str){
        int open = 0, close = 0;
        StringBuilder sb = new StringBuilder();
        for(char ch: str.toCharArray()){
            if(ch == '(') {
                open++;
            }
            else if(ch == ')') {
                close++;
            }
            sb.append(ch);
            if(open == close) {
                return sb.toString();
            }
        }
        return sb.toString();
    }
    static boolean isRight(String str){
        int count = 0;
        for (char ch: str.toCharArray()) {
            if(ch == '(') count ++;
            else count --;
            if(count < 0) return false;
        }
        return true;
    }
    static String solution(String str){
        if(str.length() == 0)
            return str;
        String u = getBalence(str);
        String v = str.substring(u.length());
        if (!isRight(u)){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <u.length()-1; i++) {
                if(u.charAt(i) == ')')
                    sb.append('(');
                else
                    sb.append(')');
            }
            return "("+solution(v)+")"+sb.toString();
        }
        return u+solution(v);

    }
}
