// 수정 버전
import kotlin.math.round

class DivideOperation: AbstractOperation() {
    override fun operation(n1: Double, n2: Double): Double {
        require(n2 != 0.0) {
            ArithmeticException("Divide by Zero")
        }

        return round((n1 / n2) * 100) / 100
    }
}

// 이전 버전
// class DivideOperation: AbstractOperation {
//     override fun operation(n1: Int, n2: Int): Int = if (n2 != 0) n1 / n2 else Int.MIN_VALUE
// }
