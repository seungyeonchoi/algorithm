import Foundation

func solution(_ progresses:[Int], _ speeds:[Int]) -> [Int] {
    var result = [1] //값이 1인 원소가 들어있는 배열 생성
    let calc: (Int,Int) -> Int = { Int(ceil(Double(100 - $0) / Double($1))) }
    var days = calc(progresses[0], speeds[0])
    for i in 1...progresses.count-1{
        let needs = calc(progresses[i], speeds[i])
        if(needs<=days){ //이전 작업이랑 동시 배포가 가능할 때
            result[result.count-1] = result[result.count-1]+1
        }else{ //새로 배포해야할 때
            result.append(1)
            days = needs
        }
    }
    
    return result
}
