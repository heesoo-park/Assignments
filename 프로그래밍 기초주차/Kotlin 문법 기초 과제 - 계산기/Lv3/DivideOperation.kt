// 수정 버전
class DivideOperation {
    fun operation(n1: Double, n2: Double): Double {
        require(n2 != 0.0) {
            ArithmeticException("Divide by Zero")
        }
        return n1 / n2
    }
}

// 이전 버전
// class DivideOperation {
//     fun divide(n1: Int, n2: Int) = if (n2 != 0) n1 / n2 else Int.MIN_VALUE
// }
