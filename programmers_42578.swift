import Foundation

func solution(_ clothes:[[String]]) -> Int {
    var dict = [String:Int]()
    clothes.forEach{ clothes in
        let key = clothes[1]
        let len = dict[key] ?? 1 //처음들어오는 타입이면 default 값 1 지정
        dict[key] = len + 1
    }
    let sum: Int = dict.reduce(1){$0 * $1.value}//초기값 1
    return sum-1 //전부 안입는 경우 -1
}
