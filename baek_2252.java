import java.util.*;

public class baek_2252 {
    /*
     * 백준 2252 줄 세우기 https://www.acmicpc.net/problem/2252
     * 알고리즘: 위상정렬(순서가 정해져있는 작업을 차례로 수행할 때, 그 순서를 결정하는 알고리즘)
     *
     * 위상정렬 문제 푸는 방법
     * 1. 초기화
     * - indegree 배열(int[]): 각 노드마다 자신에게 향하는 화살표의 갯수 => a->b 관계가 있다면, int[b]++ 해줌
     * - adj 리스트(ArrayList<ArrayList<Integer>>): 관계를 나타내는 행렬 => a->b 관계가 있다면, list.get(a).add(b)
     * - queue(Queue<Integer> = new LinkedList<Integer>()): 모든 노드 탐색
     * - visited 배열: 탐색했던 노드 기록해두는 용도
     *
     * 2. indegree가 0인 노드 탐색 -> queue에 저장
     *
     * 3. 관련된 edge의 indegree --
     *
     * 4. q가 empty상태가 될 때까지, 2,3 반복
     *
     * 5. visited의 원소 갯수와 input 노드 갯수가 동일하면 위상정렬 가능! 더 적으면 불가능!
     * -> 이때, visited를 순서대로 출력하면 위상정렬의 하나의 경우의 수 가 됨
     */
    static Scanner scan = new Scanner(System.in);
    static int n,m;
    static int[] indegree = new int[32001];
    static ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
    //static int[][] arr= new int[100000][2];
    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i=0;i<n;i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int out = scan.nextInt();
            int in = scan.nextInt();
            adjList.get(out-1).add(in);
            indegree[in]++;

        }
        Queue<Integer> q = new LinkedList<>();
        Vector<Integer> v = new Vector<>();
        for(int i = 1; i<= n;i++){
            if(indegree[i] == 0 ) q.offer(i);
        }
        while(!q.isEmpty()){
            int top = q.poll();
            v.add(top);
            for (int dest: adjList.get(top-1)){
                if(--indegree[dest] == 0){
                    q.offer(dest);
                }

            }
        }
        for(int i: v){
            System.out.print(i+" ");
        }
    }
}