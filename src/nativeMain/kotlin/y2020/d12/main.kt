package y2020.d12

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.fold(Triple(0, 0, 0)) { acc, pair ->
        pair.let {
            (if (pair.first == 'F') pair.copy(first = listOf('E', 'S', 'W', 'N')[acc.third]) else pair)
        }.let {
            when (it.first) {
                'R' -> acc.copy(third = ((1 * (it.second / 90)) + acc.third) % 4)
                'L' -> acc.copy(third = ((4 + (-1 * (it.second / 90))) + acc.third) % 4)
                'E' -> acc.copy(first = acc.first + it.second)
                'S' -> acc.copy(second = acc.second - it.second)
                'W' -> acc.copy(first = acc.first - it.second)
                else -> acc.copy(second = acc.second + it.second) // N
            }
        }
    }.printResult()
}

fun b() {
    preparedInput.fold((10L to 1L) to (0L to 0L)) { acc, pair ->
        when (pair.first) {
            'R' -> acc.copy(first = IntArray(pair.second / 90).fold(acc.first) { accR, _ -> accR.second to -accR.first })
            'L' -> acc.copy(first = IntArray(pair.second / 90).fold(acc.first) { accL, _ -> -accL.second to accL.first })
            'E' -> acc.copy(first = acc.first.first + pair.second to acc.first.second)
            'S' -> acc.copy(first = acc.first.first to acc.first.second - pair.second)
            'W' -> acc.copy(first = acc.first.first - pair.second to acc.first.second)
            'N' -> acc.copy(first = acc.first.first to acc.first.second + pair.second)
            else -> acc.copy(second = acc.second.first + acc.first.first * pair.second to acc.second.second + acc.first.second * pair.second) // F
        }
    }.second.printResult()
}