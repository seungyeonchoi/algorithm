import Foundation

func solution(_ bridge_length:Int, _ weight:Int, _ truck_weights:[Int]) -> Int {
    var trucks = truck_weights
    var bridge = Array(repeating: 0, count: bridge_length)
    var sec = 0 //경과 시간
    var totalWeight = 0 //다리 위에 있는 트럭의 총 무게

    while !bridge.isEmpty {
        // 1초마다 다리위의 트럭 또는 빈공간은 움직임
        totalWeight -= bridge.removeLast() //다리 마지막 칸에 있던 트럭이 내림
        sec += 1

        // 다리에 진입 예정인 트럭을 포함한 무게와 다리가 견딜 수 있는 무게를 비교해서
        // 견딜 수 있으면 트럭 진입 시킨다.
        if let truct = trucks.first {
            if truct + totalWeight <= weight {
                totalWeight += trucks.removeFirst() // 트럭 진입
                bridge.insert(truct,at:0) //트럭 진입 완료
            } else {
                // 견딜 수 없으면 트럭 대기하고 빈공간만 보낸다.
                bridge.insert(0,at:0)
            }
        }
    }
    
    return sec
}
