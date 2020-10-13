import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class NandM_3 {
    /*
     * 백준 15651 N과 M(3) https://www.acmicpc.net/problem/15651
     * 시간 초과-> bufferstream 이용
     * 알고리즘: 백트래킹
     */
    static int N;
    static int M;
    static Scanner scan = new Scanner(System.in);
    static StringBuilder sb = new StringBuilder();
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {

        N = scan.nextInt();
        M = scan.nextInt();
        backtracking(new Vector<Integer>());
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    public static void backtracking(Vector<Integer> tmp) throws IOException {
        if(tmp.size() == M){
            for(int i : tmp){
                sb.append(i+" ");
            }
            sb.append("\n");

            return;
        }
        for (int i = 1; i <= N ; i++) {
            tmp.add(i);
            backtracking(tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
