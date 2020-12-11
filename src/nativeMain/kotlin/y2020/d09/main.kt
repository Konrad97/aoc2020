package y2020.d09

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.findErrorOrNull().printResult()
}

fun b() {
    preparedInput.crackCode(preparedInput.findErrorOrNull())!!.printResult()
}

private const val windowSize = 26

fun List<Long>.findErrorOrNull(): Long =
    windowed(windowSize) {
        if (it.dropLast(1)
                .any { first -> it.dropLast(1).any { second -> (second != first) && ((first + second) == it.last()) } }
        ) true to it.last() else false to it.last()
    }.firstOrNull { !it.first }!!.second

fun List<Long>.crackCode(error: Long): Long? {
    forEachIndexed { idx, _ ->
        subList(idx, size).foldIndexed(0L) { subIdx, acc, element ->
            if (element == error) return@forEachIndexed
            (acc + element).also { nAcc ->
                if (nAcc == error) return subList(idx, idx + subIdx).minOrNull()!! + subList(
                    idx,
                    idx + subIdx
                ).maxOrNull()!!
            }
        }
    }
    return null
}
