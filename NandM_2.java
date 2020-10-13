import java.util.*;

public class NandM_2 {
    /*
     * 백준 15650 N과 M(2) https://www.acmicpc.net/problem/15650
     * 조합 -> 순서 생각x
     * 알고리즘: 백트래킹
     */
    static Scanner scan = new Scanner(System.in);
    static int N;
    static int M;
    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();
        backtracking(new Vector<Integer>(),1);
    }

    public static void backtracking(Vector<Integer> tmp, int idx){
        if(N == M){
            for (int i =1 ; i<=N;i++){
                System.out.print(i+" ");
            }
            return;
        }
        if(tmp.size() == M){
            for(int i: tmp){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i<=N;i++){
            if (tmp.contains(i)) continue;
//            if (!tmp.isEmpty()&&i<tmp.lastElement()) continue; // -> backtracking 인자가 tmp뿐일 때!(중복 제거)
            tmp.add(i);
            backtracking(tmp,i);
            tmp.remove(tmp.size()-1);
        }

    }
}
