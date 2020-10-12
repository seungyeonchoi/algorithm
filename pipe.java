import java.util.Scanner;


public class pipe {
    //백준 17070 파이프 옮기
    static class Pipe{
        int r;
        int c;
        int state; //1: 가로 2: 세로 3: 대각선

        public Pipe(int r, int c, int state) {
            this.r= r;
            this.c = c;
            this.state = state;
        }
    }
    static int n;
    static int count = 0;
    //가로 세로 대각선
    static int[] dr = {0,1,1};
    static int[] dc = {1,0,1};
    public static void main(String[] args) {
        int[][] map = new int[17][17]; //자동으로 0 입력됨
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
       // int[][] map = new int[n][n]; //자동으로 0 입력됨 -> 메모리 차이 별로 안남
        for (int i = 0; i < n; i++) {
            for(int j = 0;j<n; j++){
                map[i][j] = scan.nextInt(); //0: 빈 칸 ,1 : 벽
            }
        }
        Pipe p = new Pipe(0,1,1);
        dfs(map,p);
        System.out.println(count);
    }
    /*
    * 가로: 오른쪽, 오른쪽 아래
    * 세로: 아래, 오른쪽 아래
    * 대각선: 오른쪽, 아래, 오른쪽 아래
    * */
    public static void dfs(int[][] map, Pipe p){
        Pipe tmp;
        if(p.r == n-1 && p.c == n-1){
            count++;
            return;
        }
//        if(p.r < 0 || p.r>= n || p.c <0 || p.c>=n || map[p.r][p.c] == 1) {
//            return;
//        }
//        if(map[p.r][p.c+1] == 0 && p.state != 2 ){
//            tmp = new Pipe(p.r,p.c+1, 1);
//            dfs(map,tmp);
//        }
//        if(map[p.r+1][p.c] == 0 && p.state != 1){
//            tmp = new Pipe(p.r+1,p.c, 2);
//            dfs(map, tmp);
//        }
//        if(map[p.r][p.c+1] == 0 && map[p.r+1][p.c]== 0 && map[p.r+1][p.c+1]== 0) {
//            tmp = new Pipe(p.r+1,p.c+1, 3);
//            dfs(map, tmp);
//        }
        for (int i = 0; i < 3 ; i++) {
            if((i==0 && p.state == 2) || (i==1 && p.state == 1)){
                continue;
            }
            int r = p.r+dr[i];
            int c = p.c+dc[i];
            if(r>=n || c>=n || map[r][c] ==1){
                //범위를 벗어나거나 벽
                continue;
            }
            if(i==2 && (map[p.r][p.c+1]==1||map[p.r+1][p.c]==1)){
                continue; //대각선일땐 한번 더 체크
            }
            dfs(map, new Pipe(r,c,i+1));
        }
    }
}
