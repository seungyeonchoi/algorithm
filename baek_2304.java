
import java.util.Scanner;

public class baek_2304 {
    /*
     * 백준 2304 창고 다각형 https://www.acmicpc.net/problem/2304
     * 알고리즘: 브루트포스
     *
     * 인터넷에서 본 좋은 방법 - https://ssu-gongdoli.tistory.com/112
     * 1. 왼쪽에서 오른쪽으로 최댓값을 뽑는다. le[i] = max(le[i-1], arr[i])
     * 2. 오른쪽에서 왼쪽으로 최댓값을 뽑는다. re[i] = max(re[i+1], arr[i])
     * 3. 이제 왼쪽에서 오른쪽으로 쭉 가면서 넓이를 확인한다. ans += min(le[i], re[i])
     */
    static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        int n = scan.nextInt();
        int [] block = new int[1001]; //기둥정보 담는 배열
        //(좌 ~ 우 탐색 기준)
        int startMAX = 0; // 가장 먼저 등장하는 가장 높은 기둥의 왼쪽 index
        int endMAX =0; //가장 늦게 등장하는 가장 높은 기둥의 오른쪽 index
        int height = 0;
        for(int i = 0; i<n;i++){
            int x = scan.nextInt();
            int y = scan.nextInt();
            block[x] = y;
            //가장 높은 기둥 정보 update
            if(height<y){
                height = y;
                startMAX =x;
                endMAX =x+1;
            }
            //기존에 측정된 가장 높은 기둥과 똑같은 높이의 기둥이 있을 경우 -> endMax update
            else if(height==y){
                endMAX = x+1;
            }
        }

        int sum = height*(endMAX-startMAX); //가장 높은 기둥으로 만드는 지붕의 넓이 먼저 구함
        //가장 높은 기둥을 기준으로 좌측부분의 지붕 넓이 구함
        height = 0;
        for(int i = 1;i<startMAX;i++){
            height = Math.max(height,block[i]);
            sum += height;
        }
        //가장 높은 기둥을 기준으로 우측 부분의 지붕 넓이 구함
        height = 0;
        for(int i = 1000; i>endMAX-1;i--){ //endMAX-1 : 기둥 정보가 왼쪽 index 기준으로 기록되므로
            height = Math.max(height,block[i]);
            sum += height;
        }
        System.out.println(sum);
    }
}
