package pt.davidafsilva.aoc.d3

import pt.davidafsilva.aoc.loadInput
import java.awt.geom.Line2D
import java.io.BufferedReader
import kotlin.LazyThreadSafetyMode.NONE
import kotlin.math.pow
import kotlin.math.sqrt

private object ManhattanDistance {

    private data class Point(val x: Int, val y: Int) {
        companion object {
            val ZERO = Point(0, 0)
        }
    }

    private data class Line(val a: Point, val z: Point, val cost: Int, val totalCost: Int) {
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

        fun cost(p: Point): Int =
            totalCost - cost + sqrt((a.x - p.x).toDouble().pow(2) + (a.y - p.y).toDouble().pow(2)).toInt()
    }

    fun compute(): Pair<Point, Int>? {
        val (wire1Path, wire2Path) = javaClass.loadInput {
            it.readCoordinates() to it.readCoordinates()
        }

        val candidates = mutableListOf<Pair<Point, Int>>()
        wire1Path.forEach { w1p ->
            wire2Path.forEach { w2p ->
                candidates.addAll(interceptionPoints(w1p, w2p))
            }
        }

        return candidates.minBy { it.second }
    }

    private fun interceptionPoints(l1: Line, l2: Line): Collection<Pair<Point, Int>> = when {
        (l1.a == Point.ZERO && l2.a == Point.ZERO) -> emptyList()
        !Line2D.linesIntersect(
            l1.a.x.toDouble(), l1.a.y.toDouble(), l1.z.x.toDouble(), l1.z.y.toDouble(),
            l2.a.x.toDouble(), l2.a.y.toDouble(), l2.z.x.toDouble(), l2.z.y.toDouble()
        ) -> emptyList()
        else -> l1.path.intersect(l2.path).map { ip -> ip to l1.cost(ip) + l2.cost(ip) }
    }

    private fun BufferedReader.readCoordinates(): List<Line> = readLine()
        .splitToSequence(",")
        .mapNotNull { coordinate ->
            val value = coordinate.substring(1).toInt()
            value to when (coordinate[0]) {
                'R' -> Point(value, 0)
                'L' -> Point(-value, 0)
                'U' -> Point(0, value)
                'D' -> Point(0, -value)
                else -> error("unsupported operation: ${coordinate[0]}")
            }
        }
        .fold(mutableListOf()) { lines, (hop, move) ->
            val lastTrail = lines.lastOrNull()
            val sourceP = lastTrail?.z ?: Point(0, 0)
            val destinationP = Point(sourceP.x + move.x, sourceP.y + move.y)
            val cost = (lastTrail?.totalCost ?: 0) + hop
            lines.apply { add(Line(sourceP, destinationP, hop, cost)) }
        }
}

fun main() {
    println(ManhattanDistance.compute())
}
