package pt.davidafsilva.interviews

private object CardsWar {

    private val cardsValue = "23456789TJQKA"
        .foldIndexed(mutableMapOf<Char, Int>()) { idx, acc, card -> acc[card] = idx; acc }

    fun solution(a: String, b: String): Int = a.asSequence().zip(b.asSequence())
        .count { (aCard, bCard) -> aCard.cardValue() > bCard.cardValue() }

    private fun Char.cardValue() = cardsValue[this] ?: throw IllegalArgumentException("invalid card: $this")
}

fun main() {
    println(CardsWar.solution("23A84Q", "K2Q25J"))
}
