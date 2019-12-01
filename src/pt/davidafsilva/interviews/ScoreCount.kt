package pt.davidafsilva.interviews

import java.util.regex.Pattern
import kotlin.math.floor

private object ScoreCount {

    private const val OK_RESULT = "OK"
    private val pattern = Pattern.compile("\\w+(\\d+)(\\w+)?")
    private const val PATTERN_GROUP_NUMBER_IDX = 1

    fun solution(t: Array<String>, r: Array<String>): Int {
        val groupResults = t.asSequence()
            .zip(r.asSequence())
            .map { (test, result) -> test.group() to result.isOk() }
            .fold(mutableMapOf<Int, Boolean>()) { results, (group, isOk) ->
                results.apply {
                    compute(group) { _, acc ->
                        acc?.let { it && isOk } ?: isOk
                    }
                }
            }

        val passed = groupResults.count { it.value }
        return floor(passed * 100.0 / groupResults.size).toInt()
    }

    private fun String.group(): Int {
        val m = pattern.matcher(this)
        if (!m.matches()) throw IllegalArgumentException("Invalid test: $this")
        return m.group(PATTERN_GROUP_NUMBER_IDX).toInt()
    }

    private fun String.isOk() = this == OK_RESULT
}

fun main() {
    println(
        ScoreCount.solution(
            arrayOf("test1a", "test2", "test1b", "test1c", "test3"),
            arrayOf("Wrong answer", "OK", "Runtime error", "OK", "Time limit")
        )
    )
    println(
        ScoreCount.solution(
            arrayOf("codility1", "codility3", "codility2", "codility4b", "codility4a"),
            arrayOf("Wrong answer", "OK", "OK", "Runtime error", "OK")
        )
    )
}
