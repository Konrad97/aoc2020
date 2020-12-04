package one.a

import one.*

fun main() {
    getInput().run {
        forEachIndexed { idxFirst, first ->
            subList(idxFirst + 1, size).forEach { second ->
                if (first + second == 2020) return@run listOf(first, second)
            }
        }
        error("No numbers found")
    }.printResult()
}
