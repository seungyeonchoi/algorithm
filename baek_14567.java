
import java.util.*;

public class baek_14567 {
    /*
     * 백준 14567 줄 세우기 https://www.acmicpc.net/problem/14567
     * 알고리즘: 위상정렬(순서가 정해져있는 작업을 차례로 수행할 때, 그 순서를 결정하는 알고리즘)
     * 주요 아이디어: 몇 번째 학기에서 들을 수 있는지 == 자신이 몇 번째 round에서 indegree가 0이 되었는지
     * - 방법1: 처음부터 들을 수 있는 과목들을 level 1로 설정 -> queue에 과목 넣을 때 자신의 바로 앞 선수과목의 level+1 해줌
     * - 방법2: queue while문을 돌 때, 한 라운드마다 기존에 queue size만큼 for문을 돌아 첫 번째 학기에 들을 수 있는 과목을 체크함. for문이 끝나면 학기++을 해줌
     */
    static Scanner scan = new Scanner(System.in);
    static int n,m;
    static int[] indegree = new int[1001];
    static Vector<Vector<Integer>> adjList= new Vector<>();
    static class vertex{
        int node;
        int level;
        public vertex(int node, int level){
            this.node = node;
            this.level = level;
        }
    }
    public static void main(String[] args) {
        n = scan.nextInt();
        m = scan.nextInt();
        for(int i= 0; i<n;i++){
            adjList.add(new Vector<>());
        }
        for(int i =0;i<m;i++){
            int out = scan.nextInt();
            int in = scan.nextInt();
            indegree[in]++;
            adjList.get(out-1).add(in);
        }
        Queue<vertex> q = new LinkedList<>();
        for (int i = 1; i <=n ; i++) {
            if(indegree[i]==0) q.offer(new vertex(i, 1));
        }
        int [] visited = new int[n];
        while(!q.isEmpty()){
            vertex v = q.poll();
            visited[v.node-1] = v.level;
            for(int i : adjList.get(v.node-1)){
                if(--indegree[i] == 0){
                    q.offer(new vertex(i,v.level+1));
                }
            }
        }

        for(int i : visited){
            System.out.print(i+" ");
        }
    }
}
