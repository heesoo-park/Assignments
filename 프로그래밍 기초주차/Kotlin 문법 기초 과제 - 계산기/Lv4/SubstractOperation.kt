// 수정 버전
import kotlin.math.round

class SubstractOperation: AbstractOperation() {
    override fun operation(n1: Double, n2: Double): Double = round((n1 - n2) * 100) / 100
}

// 이전 버전
// class SubstractOperation: AbstractOperation {
//     override fun operation(n1: Int, n2: Int): Int = n1 - n2
// }
