import java.util.*;

public class numberBaseball {
    /*
     * 백준 2503 숫자야구 https://www.acmicpc.net/problem/2503
     * 알고리즘: 브루트포스
     */
    static Scanner scan = new Scanner(System.in);
    static int n;
    static boolean[] res = new boolean[999]; //123  ~ 987
    public static void main(String[] args) {
        n = scan.nextInt();
        HashSet<Integer> hashSet = new HashSet<>();
        for(int i= 123; i<=987;i++){
            hashSet.add(i/100); //100의 자리 수
            hashSet.add((i%100) /10); //10의 자릿 수
            hashSet.add((i%100)%10); //1의 자리 수
            //숫자에 0은 포함x, 같은 수 x -> 중복 제거
            if(!hashSet.contains(0) && hashSet.size()==3){
                res[i] = true;
            }
            hashSet.clear();
        }
        solve();
        int cnt = 0;
        for(int i= 123; i<=987;i++){
            if(res[i]){
                cnt++;
            }

        }
        System.out.println(cnt);
    }
    public static void solve(){
        char[] num;
        int strike, ball;
        for(int i = 0; i<n ;i++){
            num = String.valueOf(scan.nextInt()).toCharArray();
            strike = scan.nextInt();
            ball = scan.nextInt();
            for(int j = 123; j<=987; j++){
                int strike_cnt = 0, ball_cnt = 0;
                if (res[j]){
                    char[] ans = String.valueOf(j).toCharArray();
                    //j(정답)과 num(추측값)의 strike, ball계산
                    for(int k=0;k<3;k++){
                        if(num[k] == ans[0] || num[k] ==ans[1] || num[k] == ans[2]){
                            if(num[k] == ans[k]){
                                strike_cnt++;
                            }
                            else{
                                ball_cnt++;
                            }
                        }
                    }
                    //strike, ball과 추측값의 결과 비교
                    if(strike_cnt != strike || ball_cnt != ball){
                        res[j] = false;
                    }
                    //안맞으면 res[j] = false
                }
            }
        }
    }
}
