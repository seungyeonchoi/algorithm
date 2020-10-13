import java.util.*;

public class NandM {
    /*
    * 백준 15649 N과 M(1) https://www.acmicpc.net/problem/15649
    * 알고리즘: 백트래킹
    * */
    static int N, M;
    static Vector<Vector<Integer>> ans = new Vector<>();
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        N = scan.nextInt();
        M = scan.nextInt();

        //solve(new Vector<Integer>(), 1);
        backtracking(new Vector<Integer>());
//        for (Vector<Integer> v: ans){
//            for(Integer i: v){
//                System.out.print(i+" ");
//            }
//            System.out.println();
//        }
    }
    public static void backtracking(Vector<Integer> tmp){
        if(tmp.size() == M){
            //ans.add(new Vector<>(tmp));
            for(Integer i: tmp){
                System.out.print(i+" ");
            }
            System.out.println();
            return;
        }
        for(int i =1 ; i<=N;i++){
            if(tmp.contains(i)) continue;
            tmp.add(i);
            backtracking(tmp);
            tmp.remove(tmp.size()-1);
        }
    }

   /*
   * 아래 코드가 틀린 이유:
   * 1 -> 1,2,3,4
   * 2 -> 1,2,3,4 이런식으로 돌아야하는데, 중복체크를 for문 밖에서해서 제대로 모든 경우를 체크하지 못함
   *
   * */

//    public static void solve(Vector<Integer> tmp, int num){
//        System.out.println(tmp+",,,"+ num+ "시작 ");
//        if (tmp.size() == M){
//            System.out.println("tmp.size() == m  " + tmp);
//            ans.add(tmp.toString());
//            tmp.remove(tmp.size()-1);
//            //tmp.clear();
//            return;
//        }
//        if (!tmp.contains(num)){
//            tmp.add(num);
//            for(int i=1; i< N; i++){
//                if(i == num) continue;
//                System.out.println(i+"번째 for >>>>>>"+tmp);
//                solve(tmp,i);
//
//            }
//        }
//        else{
//            System.out.println("중복 ");
//        }
//
//
//       // tmp.remove((Object)i);
//
//    }
}
