public class programmers_43162 {
    /*
     * 프로그래머스 43162 네트워크 https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
     * 알고리즘: 완전탐색 - dfs
     *
     * 구현 팁
     * 1. (이번 문제만 해당) '연결' 은 상,하,좌,우가 아니라 한 각 행의 원소가 1이면 true
     * -> 매 라운드마다 1인 원소의 index를 찾고 ,그 index로 옮겨가서(재귀) 또 1인 index를 찾음
     * -> 방문하지 않은 index가 없을 때 까지 반복
     * -> dfs 끝나면(연결된 컴퓨터 모두 탐색) main함수로 돌아오는데, 그 때 네트워크 갯수를 증가시켜줌
     * -> 방문하지 않은 컴퓨터를 시작으로 다시 dfs
     *
     * 2. 타겟넘버와의 차이점
     * -> 탐색 시 완료 조건이 특정 계산으로 나오는게 아니라 ,그냥 가볼 수 있는 모든 곳을 가보면 종료!
     */
    class Solution {

        // int[] dx = {0,0,-1,1};
        // int[] dy= {-1,1,0,0};
        boolean[] visited = new boolean[200];
        public int solution(int n, int[][] computers) {
            int answer = 0;
            for(int i = 0; i<n;i++){
                if(!visited[i]){
                    dfs(computers,i,n);
                    answer++;
                }
            }
            // for(int i = 0; i<n;i++){
            //     for(int j = 0; j<n ;j++){
            //         if(computers[i][j]==1){
            //             dfs(computers,i,j,n);
            //             answer++;
            //         }
            //     }
            // }


            return answer;
        }
        //map[dy][dx]
        // void dfs(int[][] map, int y , int x, int size){
        //     map[y][x] = 0;
        //     for(int i =0;i<4;i++){
        //         int ddy = y + dy[i];
        //         int ddx = x + dx[i];
        //         if(ddx<0 || ddy <0 || ddx >=size || ddy >= size) //벽
        //             continue;
        //         if(map[ddy][ddx]==0) continue; //연결x
        //         dfs(map, ddy,ddx,size);
        //     }
        // }
        void dfs(int[][] map, int y , int size){
            visited[y] = true;
            map[y][y] = 0;
            for(int i= 0; i<size;i++){
                if(map[y][i]==1){
                    map[y][i] = 0;
                    if(visited[i]) continue;
                    dfs(map,i,size);
                }
            }
        }
    }
}
