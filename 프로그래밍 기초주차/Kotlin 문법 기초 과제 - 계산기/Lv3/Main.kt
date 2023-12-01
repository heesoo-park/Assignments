// 수정 버전
fun main() = with(System.`in`.bufferedReader()) {
    val calculator = Calculator()

    while (true) {
        println("원하는 연산을 선택해주세요.")
        println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기 5. 종료")
        var symbol = readln().toInt()
        var n1: Double = 0.0
        var n2: Double = 0.0

        // 제시된 범위 바깥이면 다시 유효한 연산 선택 유도
        while (symbol > 5 || symbol <= 0) {
            println("에러 : 유효하지 않은 연산입니다.")
            println("다시 연산을 선택해주세요.")
            println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
            symbol = readln().toInt()
        }

        if (symbol == 5) break

        if (calculator.accNum == Double.MIN_VALUE) {
            println("두 수를 입력해주세요(공백으로 구분)")
            val input = readln().split(" ")
            n1 = input[0].toDouble()
            n2 = input[1].toDouble()
        } else {
            println("숫자 하나를 입력해주세요")
            n1 = calculator.accNum
            n2 = readln().toDouble()
        }


        when (symbol) {
            1 -> println("$n1 더하기 $n2 결과 : ${calculator.add(AddOperation(), n1, n2)}")
            2 -> println("$n1 빼기 $n2 결과 : ${calculator.substract(SubstractOperation(), n1, n2)}")
            3 -> println("$n1 곱하기 $n2 결과 : ${calculator.multiply(MultiplyOperation(), n1, n2)}")
            4 -> println("$n1 나누기 $n2 결과 : ${calculator.divide(DivideOperation(), n1, n2)}")
            else -> println("ERROR")
        }
    }

    calculator.endMessage()
}

// 계산 결과
// fun main() = with(System.`in`.bufferedReader()) {
//     val calculator = Calculator()

//     calculator.startMessage()
//     calculator.start()
//     calculator.stopMessage()
// }
