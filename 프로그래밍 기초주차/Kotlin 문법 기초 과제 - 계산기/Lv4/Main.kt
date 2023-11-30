fun main() = with(System.`in`.bufferedReader()) {
    val calculator = Calculator()

    calculator.startMessage()
    calculator.start()
    calculator.stopMessage()
}
