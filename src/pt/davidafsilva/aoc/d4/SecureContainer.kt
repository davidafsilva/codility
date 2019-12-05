package pt.davidafsilva.aoc.d4

private object SecureContainer {

    fun compute(start: Int, end: Int): Int = IntRange(start, end)
        .filter { isValidPassword(it) }
        .count()

    private fun isValidPassword(candidate: Int): Boolean = candidate < 1_000_000 &&
        hasAdjacentNumber(candidate) &&
        isIncreasingFromLeftToRight(candidate)

    fun hasAdjacentNumber(candidate: Int): Boolean {
        val str = candidate.toString()
        var foundAtLeastOnePair = false
        var prevChar: Char? = null
        var prevCount = 0
        str.forEach { c ->
            when (c) {
                prevChar -> prevCount++
                else -> {
                    foundAtLeastOnePair = foundAtLeastOnePair || prevCount == 2
                    if (foundAtLeastOnePair) return true
                    prevChar = c
                    prevCount = 1
                }
            }
        }
        return foundAtLeastOnePair || prevCount == 2
    }

    private fun isIncreasingFromLeftToRight(candidate: Int): Boolean {
        val str = candidate.toString()
        for ((idx, c) in str.withIndex()) {
            if (idx > 0 && str[idx - 1] > c) return false
        }
        return true
    }
}

fun main() {
    println(SecureContainer.hasAdjacentNumber(112233))
    println(SecureContainer.hasAdjacentNumber(123444))
    println(SecureContainer.hasAdjacentNumber(111122))
    println(SecureContainer.compute(246515, 739105))
}
