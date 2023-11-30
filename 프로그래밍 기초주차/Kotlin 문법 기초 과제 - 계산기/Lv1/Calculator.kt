class Calculator {
    fun calculate() {
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

        var result: Int = calculate(symbol, n1, n2)

        if (result != Int.MIN_VALUE) println("결과 : $result")
        else println("에러 : 숫자를 0으로 나눌 수 없습니다.")
    }

    private fun calculate(symbol: Int, n1: Int, n2: Int): Int {
        return when (symbol) {
            1 -> add(n1, n2)
            2 -> substract(n1, n2)
            3 -> multiply(n1, n2)
            4 -> divide(n1, n2)
            else -> 0 // 위에서 정확한 연산 번호를 입력받고 들어오기 때문에 걸리지 않는 조건
        }
    }

    private fun add(n1: Int, n2: Int) = n1 + n2
    private fun substract(n1: Int, n2: Int) = n1 - n2
    private fun multiply(n1: Int, n2: Int) = n1 * n2
    private fun divide(n1: Int, n2: Int) = if (n2 != 0) n1 / n2 else Int.MIN_VALUE
}
