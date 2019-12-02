package pt.davidafsilva.aoc.d2

object IntcodeProgram {

    private const val HALT_CODE = 99
    private const val SUM_CODE = 1
    private const val TIMES_CODE = 2
    private const val TARGET_VALUE = 19_690_720

    fun run(): Int {
        val originalCodes = loadCodes()

        for (noun in 0..99) {
            for (verb in 0..99) {
                val codes = originalCodes.toMutableList()
                codes[1] = noun
                codes[2] = verb
                runCodes(codes)

                val code = codes.getOrNull(0) ?: 0
                if (code == TARGET_VALUE) {
                    return 100 * noun + verb
                }
            }
        }

        return -1;
    }

    private fun loadCodes(): List<Int> = javaClass.getResourceAsStream("input")
        .use { stream ->
            stream.bufferedReader()
                .readLine()
                .splitToSequence(",")
                .map { it.toInt() }
                .toList()
        }

    private fun runCodes(codes: MutableList<Int>) {
        (0..(codes.size - 3)).step(4).forEach { idx ->
            when (codes[idx]) {
                HALT_CODE -> return
                SUM_CODE -> executeOperation(codes, idx + 1, idx + 2, idx + 3, Int::plus)
                TIMES_CODE -> executeOperation(codes, idx + 1, idx + 2, idx + 3, Int::times)
            }
        }
    }

    private fun executeOperation(
        codes: MutableList<Int>,
        arg1IndexIndex: Int,
        arg2IndexIndex: Int,
        resultIndexIndex: Int,
        op: (Int, Int) -> Int
    ) {
        val arg1Idx = codes[arg1IndexIndex]
        val arg2Idx = codes[arg2IndexIndex]
        val resultIdx = codes[resultIndexIndex]
        codes[resultIdx] = op(codes[arg1Idx], codes[arg2Idx])
    }
}

fun main() {
    println(IntcodeProgram.run())
}
