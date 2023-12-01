// 수정 버전
fun main() = with(System.`in`.bufferedReader()) {
    var accNum = Double.MIN_VALUE
    lateinit var calculator: Calculator

    println("계산기 ON")
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

        if (accNum == Double.MIN_VALUE) {
            println("두 수를 입력해주세요(공백으로 구분)")
            val input = readln().split(" ")
            n1 = input[0].toDouble()
            n2 = input[1].toDouble()
        } else {
            println("숫자 하나를 입력해주세요")
            print("$accNum ")
            n1 = accNum
            n2 = readln().toDouble()
        }

        when (symbol) {
            1 -> {
                calculator = Calculator(AddOperation())
                println("$n1 더하기 $n2 결과 : ${calculator.operate(n1, n2).also { accNum = it }}")
            }
            2 -> {
                calculator = Calculator(SubstractOperation())
                println("$n1 빼기 $n2 결과 : ${calculator.operate(n1, n2).also { accNum = it }}")
            }
            3 -> {
                calculator = Calculator(MultiplyOperation())
                println("$n1 곱하기 $n2 결과 : ${calculator.operate(n1, n2).also { accNum = it }}")
            }
            4 -> {
                calculator = Calculator(DivideOperation())
                println("$n1 나누기 $n2 결과 : ${calculator.operate(n1, n2).also { accNum = it }}")
            }
            else -> println("ERROR")
        }
    }

    calculator.endMessage()
}

// 이전 버전
// fun main() = with(System.`in`.bufferedReader()) {
//     val calculator = Calculator()

//     calculator.startMessage()
//     calculator.start()
//     calculator.stopMessage()
// }
