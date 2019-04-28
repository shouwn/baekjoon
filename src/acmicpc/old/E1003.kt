package acmicpc.old

fun main(args: Array<String>) {
    System.`in`.bufferedReader().use {br ->
        for (i in 0..(br.readLine().toInt() - 1)) {
            println(Fibonacci.of(br.readLine().toInt()).let { "${it.zeroCount} ${it.oneCount}" })
        }
    }
}

data class Fibonacci(
        val number: Int,
        val zeroCount: Int,
        val oneCount: Int
) {

    companion object {
        val memo = mutableMapOf<Int, Fibonacci>()

        fun of(n: Int): Fibonacci =
                when (n) {
                    0 -> Fibonacci(0, 1, 0).also {
                        memo[0] = it
                    }
                    1 -> Fibonacci(1, 0, 1).also {
                        memo[1] = it
                    }
                    else -> ((memo[n - 1] ?: of(n - 1)) + (memo[n - 2] ?: of(
                        n - 2
                    ))).also {
                        memo[n] = it
                    }
                }
    }

    operator fun plus(other: Fibonacci): Fibonacci {
        val newNumber = if (this.number < other.number) {
            other.number + 1
        } else {
            this.number + 1
        }

        return Fibonacci(newNumber, this.zeroCount + other.zeroCount, this.oneCount + other.oneCount).also {
            memo[newNumber] = it
        }
    }
}