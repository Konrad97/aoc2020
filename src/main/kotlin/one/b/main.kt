package one.b

import one.*

fun main() {
    getInput().run {
        forEachIndexed { idxFirst, first ->
            subList(idxFirst + 1, size).forEachIndexed { idxSecond, second ->
                subList(idxSecond + 1, size).forEach { third ->
                    if (first + second + third == 2020) return@run listOf(first, second, third)
                }
            }
        }
        error("No numbers found")
    }.printResult()
}