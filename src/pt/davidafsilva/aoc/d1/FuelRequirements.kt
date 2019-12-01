package pt.davidafsilva.aoc.d1

private object FuelRequirements {

    fun compute(): Int = javaClass.getResourceAsStream("input")
        .use { stream ->
            stream.bufferedReader()
                .lineSequence()
                .map { mass -> computeFuelForMass(mass.toInt()) }
                .sum()
        }

    private fun computeFuelForMass(mass: Int): Int {
        val fuel = mass / 3 - 2
        return when {
            fuel < 0 -> 0
            fuel > 0 -> fuel + computeFuelForMass(fuel)
            else -> fuel
        }
    }
}

fun main() {
    println(FuelRequirements.compute())
}
