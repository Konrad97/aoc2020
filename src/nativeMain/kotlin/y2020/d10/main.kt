package y2020.d10

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.maxOrNull()!!.let { max ->
        (preparedInput + (max + 3) + 0)
            .sorted()
            .zipWithNext()
            .fold(mutableMapOf<Int, Int>()) { acc, pair ->
                (pair.second - pair.first).let { diff ->
                    acc.also { it[diff] = (it[diff] ?: 0) + 1 }
                }
            }
    }.printResult()
}

fun b() {
    preparedInput.sorted().depthSearch(0, preparedInput.maxOf { it }).printResult()
}

val cache = mutableMapOf<Int, Long>()

fun List<Int>.depthSearch(value: Int, goal: Int): Long {
    return cache[value] ?: this.takeWhile { it <= value + 3 }
        .foldIndexed(0L) { idx, acc, candidate ->
            acc + (if (candidate == goal) 1L else this.drop(idx + 1)
                .depthSearch(candidate, goal)).also { cache[candidate] = it }
        }
}