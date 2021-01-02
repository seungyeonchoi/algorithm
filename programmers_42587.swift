import Foundation

struct Document {
    var num: Int
    var priority: Int
}

func solution(_ priorities:[Int], _ location:Int) -> Int {
    var documents = [Document]()
    var order = [Int]()

    for i in 0...priorities.count-1{
        var document = Document(num:i, priority: priorities[i])
        documents.append(document)
    }
    
    while !documents.isEmpty{
        let max = documents.max { $0.priority < $1.priority } //남은 문서 중 우선순위 가장 높은 거 찾기
        if let document = documents.first{
            if(document.priority == max!.priority){ //현재 작업할 문서의 우선순위가 가장 높다면
                order.append(document.num) //최종 작업 순서 배열에 추가
                if(document.num == location){
                    return order.count
                }
            }else{
                documents.append(document) //우선순위 가장 높지 않으므로 맨 뒤로 보냄
            } 
        }
        documents.removeFirst() //이번 라운드에 작업한 문서 삭제
    }
    return 0
}
