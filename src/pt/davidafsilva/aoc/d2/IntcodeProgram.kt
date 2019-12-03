package pt.davidafsilva.aoc.d2

import pt.davidafsilva.aoc.loadInput

private typealias Instructions = MutableList<Int>

object IntcodeProgram {

    private const val HALT_CODE = 99
    private const val SUM_CODE = 1
    private const val TIMES_CODE = 2
    private const val TARGET_VALUE = 19_690_720

    fun run(): Int {
        val instructions = javaClass.loadInput {
            it.readLine()
                .splitToSequence(",")
                .map { it.toInt() }
                .toMutableList()
        }

        for (noun in 0..99) {
            for (verb in 0..99) {
                val output = instructions.toMutableList().execute(noun, verb)[0]
                if (output == TARGET_VALUE) {
                    return 100 * noun + verb
                }
            }
        }

        return -1;
    }

    private fun Instructions.execute(noun: Int, verb: Int) = apply {
        set(1, noun)
        set(2, verb)

        IntRange(0, size - 3).step(4).forEach { idx ->
            when (get(idx)) {
                HALT_CODE -> return this@execute
                SUM_CODE -> executeOperation(idx, Int::plus)
                TIMES_CODE -> executeOperation(idx, Int::times)
            }
        }
    }

    private fun Instructions.executeOperation(instructionIndex: Int, op: (Int, Int) -> Int) {
        val arg1Idx = get(instructionIndex + 1)
        val arg2Idx = get(instructionIndex + 2)
        val resultIdx = get(instructionIndex + 3)
        set(resultIdx, op(get(arg1Idx), get(arg2Idx)))
    }
}

fun main() {
    println(IntcodeProgram.run())
}
