// 수정 버전
class Calculator(private val operate: AbstractOperation) {
    fun operate(n1: Double, n2: Double): Double = operate.operation(n1, n2)

    fun endMessage() = println("계산기 OFF")
}

// 이전 버전
// class Calculator {
//     // 추가연산인지 확인하기 위한 변수
//     private var isFirst = true
//     // 추가연산을 위한 초기값
//     private var initialValue: Int = 0
//     // 연산기호 선택 변수
//     private var symbol: Int = 0
//     // 입력 숫자 값 변수들
//     private var n1: Int = 0
//     private var n2: Int = 0

//     // 연산 클래스 객체
//     private val addOperation = AddOperation()
//     private val substractOperation = SubstractOperation()
//     private val multiplyOperation = MultiplyOperation()
//     private val divideOperation = DivideOperation()

//     fun start() {
//         // 반복
//         repeatOperation()
//     }

//     fun selectSymbol() {
//         if (isFirst) {
//             // 연산 선택
//             println("원하는 연산을 선택해주세요.")
//             println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
//             symbol = readln().toInt()

//             // 제시된 범위 바깥이면 다시 유효한 연산 선택 유도
//             while (symbol > 5 || symbol <= 0) {
//                 println("에러 : 유효하지 않은 연산입니다.")
//                 println("다시 연산을 선택해주세요.")
//                 println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
//                 symbol = readln().toInt()
//             }
//         } else {
//             println("추가로 원하는 연산을 선택해주세요.")
//             println("계산을 멈추고 싶으면 5를 눌러주세요.")
//             println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
//             symbol = readln().toInt()

//             while (symbol > 5 || symbol <= 0) {
//                 println("에러 : 유효하지 않은 연산입니다.")
//                 println("다시 연산을 선택해주세요.")
//                 println("계산을 멈추고 싶으면 5를 눌러주세요.")
//                 println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
//                 symbol = readln().toInt()
//             }
//         }
//     }

//     fun getInput() {
//         if (isFirst) {
//             // 연산을 적용할 두 수 입력
//             println("두 수를 입력해주세요(공백로 구분)")
//             val input = readln().split(" ")
//             n1 = input[0].toInt()
//             n2 = input[1].toInt()
//         } else {
//             // 이후 연산의 초기값과 연산할 수를 입력
//             println("숫자 하나를 입력해주세요")
//             print("$initialValue ")
//             n2 = readln().toInt()
//         }

//     }

//     fun repeatOperation() {
//         // 연산 기호 선택
//         selectSymbol()
//         if (symbol == 5) return
//         // 입력 받기
//         getInput()

//         // 무한 루프
//         while (true) {
//             // 계산 결과
//             val result = if (isFirst) {
//                 isFirst = false
//                 calculate(symbol, n1, n2)
//             } else {
//                 calculate(symbol, initialValue, n2)
//             }

//             // 0으로 숫자를 나누려하지 않았다면
//             if (result != Int.MIN_VALUE) {
//                 // 계산 결과를 이후 연산의 초기값으로 저장
//                 initialValue = result
//                 println("결과 : $result \n")
//             } else {
//                 // 에러 출력 후 계산기 종료
//                 println("에러 : 숫자를 0으로 나눌 수 없습니다.")
//                 break
//             }

//             // 연산 기호 선택
//             selectSymbol()
//             if (symbol == 5) return
//             // 입력 받기
//             getInput()
//         }
//     }

//     // 사용자의 입력에 맞는 연산을 실행하는 메소드
//     private fun calculate(symbol: Int, n1: Int, n2: Int): Int {
//         return when (symbol) {
//             1 -> addOperation.operation(n1, n2)
//             2 -> substractOperation.operation(n1, n2)
//             3 -> multiplyOperation.operation(n1, n2)
//             4 -> divideOperation.operation(n1, n2)
//             else -> 0 // 위에서 정확한 연산 번호를 입력받고 들어오기 때문에 걸리지 않는 조건
//         }
//     }

//     // 안내 메세지
//     fun startMessage() = println("계산기가 시작되었습니다.\n")
//     fun stopMessage() = println("\n계산기가 종료되었습니다.")
// }
