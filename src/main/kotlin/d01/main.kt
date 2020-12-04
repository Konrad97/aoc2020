package d01

fun main() {
    a()
    b()
}

fun a() {
    getInput().run {
        forEachIndexed { idxFirst, first ->
            subList(idxFirst + 1, size).forEach { second ->
                if (first + second == 2020) return@run listOf(first, second)
            }
        }
        error("No numbers found")
    }.printResult()
}

fun b() {
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