class Calculator {
    // 추가연산인지 확인하기 위한 변수
    private var isNotFirst = false
    private var initialValue: Int = 0

    fun selectSymbol() {
        // 연산 선택
        println("원하는 연산을 선택해주세요.")
        println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
        var symbol = readln().toInt()

        // 제시된 범위 바깥이면 다시 유효한 연산 선택 유도
        while (symbol > 5 || symbol <= 0) {
            println("에러 : 유효하지 않은 연산입니다.")
            println("다시 연산을 선택해주세요.")
            println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
            symbol = readln().toInt()
        }

        if (symbol == 5) return

        // 연산을 적용할 두 수 입력
        println("두 수를 입력해주세요(공백로 구분)")
        val input = readln().split(" ")
        val n1 = input[0].toInt()
        var n2 = input[1].toInt()

        // 무한 루프
        while (true) {
            // 계산 결과
            val result = if (isNotFirst) {
                calculate(symbol, initialValue, n2)
            } else {
                isNotFirst = true
                calculate(symbol, n1, n2)
            }

            // 0으로 숫자를 나누려하지 않았다면
            if (result != Int.MIN_VALUE) {
                // 계산 결과를 이후 연산의 초기값으로 저장
                initialValue = result
                println("결과 : $result \n")
            } else {
                // 에러 출력 후 계산기 종료
                println("에러 : 숫자를 0으로 나눌 수 없습니다.")
                break
            }

            println("추가로 원하는 연산을 선택해주세요.")
            println("계산을 멈추고 싶으면 5를 눌러주세요.")
            println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
            symbol = readln().toInt()

            while (symbol > 5 || symbol <= 0) {
                println("에러 : 유효하지 않은 연산입니다.")
                println("다시 연산을 선택해주세요.")
                println("계산을 멈추고 싶으면 5를 눌러주세요.")
                println("1. 더하기  2. 빼기  3. 곱하기  4. 나누기  5. 종료")
                symbol = readln().toInt()
            }

            if (symbol == 5) break

            // 이후 연산의 초기값과 연산할 수를 입력
            println("숫자 하나를 입력해주세요")
            n2 = readln().toInt()
        }
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

    // 안내 메세지
    fun startMessage() = println("계산기가 시작되었습니다.\n")
    fun stopMessage() = println("\n계산기가 종료되었습니다.")
}
