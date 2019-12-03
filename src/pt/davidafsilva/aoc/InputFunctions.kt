package pt.davidafsilva.aoc

import java.io.BufferedReader

fun <R> Class<*>.loadInput(reader: (BufferedReader) -> R): R = getResourceAsStream("input").use { stream ->
    reader(stream.bufferedReader())
}
