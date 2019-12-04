package pt.davidafsilva.aoc.d3

import pt.davidafsilva.aoc.loadInput
import java.io.BufferedReader
import kotlin.math.abs

private object ManhattanDistance {

    private data class Point(val x: Int, val y: Int) {
        companion object {
            val ZERO = Point(0, 0)
        }
    }

    fun compute(): Int? {
        val (wire1Paints, wire2Paints) = javaClass.loadInput {
            it.readCoordinates() to it.readCoordinates()
        }

        val candidates = mutableListOf<Point>()
        wire1Paints.forEach { w1p ->
            wire2Paints.forEach { w2p ->
                if (w1p.x == w2p.x && w1p.y == w2p.y) candidates.add(w1p)
            }
        }

        return candidates.map { abs(it.x) + abs(it.y) }.min()
    }

    private fun BufferedReader.readCoordinates(): List<Point> = readLine()
        .splitToSequence(",")
        .mapNotNull { coordinate ->
            val value = coordinate.substring(1).toInt()
            when (coordinate[0]) {
                'L' -> Point(-value, 0)
                'R' -> Point(value, 0)
                'U' -> Point(0, value)
                'D' -> Point(0, -value)
                else -> null
            }
        }
        .fold(mutableListOf()) { points, move ->
            val lastLocation = if (points.isEmpty()) Point.ZERO else points.last()
            val xRange = if (move.x != 0) {
                val x = lastLocation.x + move.x
                if (lastLocation.x > x) IntProgression.fromClosedRange(lastLocation.x, x, -1)
                else IntProgression.fromClosedRange(lastLocation.x, x, 1)
            } else null
            val yRange = if (move.y != 0) {
                val y = lastLocation.y + move.y
                if (lastLocation.y > y) IntProgression.fromClosedRange(lastLocation.y, y, -1)
                else IntProgression.fromClosedRange(lastLocation.y, y, 1)
            } else null

            points.apply {
                xRange?.forEach { x -> if (x != 0 || lastLocation.y != 0) add(Point(x, lastLocation.y)) }
                yRange?.forEach { y -> if (y != 0 || lastLocation.x != 0) add(Point(lastLocation.x, y)) }
            }
        }
}

fun main() {
    println(ManhattanDistance.compute())
}
