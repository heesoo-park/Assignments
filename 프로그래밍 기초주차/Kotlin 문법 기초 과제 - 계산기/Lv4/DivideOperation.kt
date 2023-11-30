package com.example.forassignment.level4

class DivideOperation: AbstractOperation {
    override fun operation(n1: Int, n2: Int): Int = if (n2 != 0) n1 / n2 else Int.MIN_VALUE
}