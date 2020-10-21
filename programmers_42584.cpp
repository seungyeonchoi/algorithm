#include <iostream>
#include <string>
#include <vector>

using namespace std;

/* 백준 프로그래머스 42584 주식가격 https://programmers.co.kr/learn/courses/30/lessons/42584?language=cpp
* 
* 문제 설명: 가격이 최초로 떨어지기까지 걸린 시간
*/
vector<int> solution(vector<int> prices) {
    vector<int> answer;
    for(int i = 0 ;i<prices.size()-1;i++){
        int count = 0;
        int j = i+1;
        for(;j<prices.size();j++){
            count++;
            if(prices[i] > prices[j]){
                break;
            }
               
        }
        answer.push_back(count); 
    }
    answer.push_back(0);
    return answer;
}

//스택을 활용한 코드
// vector<int> solution(vector<int> prices) {
//     vector<int> answer(prices.size());
//     stack<int> s;
//     int size = prices.size();
//     for(int i=0;i<size;i++){
//         while(!s.empty()&&prices[s.top()]>prices[i]){
//             answer[s.top()] = i-s.top();
//             s.pop();
//         }
//         s.push(i);
//     }
//     while(!s.empty()){
//         answer[s.top()] = size-s.top()-1;
//         s.pop();
//     }
//     return answer;
// }
