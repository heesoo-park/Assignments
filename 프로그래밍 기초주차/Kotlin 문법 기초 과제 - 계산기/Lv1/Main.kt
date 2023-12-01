// 수정 버전
fun main() = with(System.`in`.bufferedReader()) {
    val calculator = Calculator()

    println("원하는 연산을 선택해주세요.")
    println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기")
    var symbol = readln().toInt()

    // 제시된 범위 바깥이면 다시 유효한 연산 선택 유도
    while (symbol >= 5 || symbol <= 0) {
        println("에러 : 유효하지 않은 연산입니다.")
        println("다시 연산을 선택해주세요.")
        println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기")
        symbol = readln().toInt()
    }

    println("두 수를 입력해주세요(공백으로 구분)")
    val input = readln().split(" ")
    val n1 = input[0].toInt()
    val n2 = input[1].toInt()

    when (symbol) {
        1 -> println("계산결과 : ${calculator.add(n1, n2)}")
        2 -> println("계산결과 : ${calculator.substract(n1, n2)}")
        3 -> println("계산결과 : ${calculator.multiply(n1, n2)}")
        4 -> println("계산결과 : ${calculator.divide(n1, n2)}")
        else -> println("ERROR")
    }
}

// 이전 버전
// fun main() = with(System.`in`.bufferedReader()) {
//     val calculator = Calculator()

//     calculator.calculate()
// }
