package pt.davidafsilva.aoc.d3

import pt.davidafsilva.aoc.loadInput
import java.awt.geom.Line2D
import java.io.BufferedReader
import kotlin.LazyThreadSafetyMode.NONE
import kotlin.math.abs

private object ManhattanDistance {

    private data class Point(val x: Int, val y: Int) {
        companion object {
            val ZERO = Point(0, 0)
        }
    }

    private data class Line(val a: Point, val z: Point) {
        val path: List<Point> by lazy(NONE) {
            when (a.x) {
                z.x -> {
                    val yRange = if (a.y > z.y) IntProgression.fromClosedRange(a.y, z.y, -1)
                    else IntProgression.fromClosedRange(a.y, z.y, 1)
                    yRange.map { Point(a.x, it) }
                }
                else -> {
                    val xRange = if (a.x > z.x) IntProgression.fromClosedRange(a.x, z.x, -1)
                    else IntProgression.fromClosedRange(a.x, z.x, 1)
                    xRange.map { Point(it, a.y) }
                }
            }
        }
    }

    fun compute(): Int? {
        val (wire1Path, wire2Path) = javaClass.loadInput {
            it.readCoordinates() to it.readCoordinates()
        }

        val candidates = mutableListOf<Point>()
        wire1Path.forEach { w1p ->
            wire2Path.forEach { w2p ->
                candidates.addAll(interceptionPoints(w1p, w2p))
            }
        }

        return candidates.map { abs(it.x) + abs(it.y) }.min()
    }

    private fun interceptionPoints(l1: Line, l2: Line): Collection<Point> = when {
        (l1.a == Point.ZERO && l2.a == Point.ZERO) -> emptyList()
        !Line2D.linesIntersect(
            l1.a.x.toDouble(), l1.a.y.toDouble(), l1.z.x.toDouble(), l1.z.y.toDouble(),
            l2.a.x.toDouble(), l2.a.y.toDouble(), l2.z.x.toDouble(), l2.z.y.toDouble()
        ) -> emptyList()
        else -> l1.path.intersect(l2.path)
    }

    private fun BufferedReader.readCoordinates(): List<Line> = readLine()
        .splitToSequence(",")
        .mapNotNull { coordinate ->
            val value = coordinate.substring(1).toInt()
            when (coordinate[0]) {
                'R' -> Point(value, 0)
                'L' -> Point(-value, 0)
                'U' -> Point(0, value)
                'D' -> Point(0, -value)
                else -> null
            }
        }
        .fold(mutableListOf()) { lines, move ->
            val sourceP = lines.lastOrNull()?.z ?: Point(0, 0)
            val destinationP = Point(sourceP.x + move.x, sourceP.y + move.y)
            val line = Line(sourceP, destinationP)
            lines.apply { add(line) }
        }
}

fun main() {
    println(ManhattanDistance.compute())
}
