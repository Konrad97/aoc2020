package y2020.d05

import kotlin.math.ceil
import kotlin.math.pow

fun main() {
    a()
    b()
}

fun a() {
    preparedInputAsStrings.map { entry ->
        entry.findSeat()
    }.maxByOrNull { it.first * 8 + it.second }?.printResult() ?: error("No max found")
}

fun b() {
    println("FFFBFBFRRR".findSeat().printResult())
    println("FFFBFBFRRR".seatToInt())

}

fun String.findSeat(): Pair<Int, Int> {
    return fold(0..127 to 0..7) { acc, direction ->
        when (direction) {
            'F' -> acc.first.first..acc.first.last - ceil((acc.first.last - acc.first.first) / 2.0).toInt() to acc.second
            'B' -> acc.first.first + ceil((acc.first.last - acc.first.first) / 2.0).toInt()..acc.first.last to acc.second
            'L' -> acc.first to acc.second.first..acc.second.last - ceil((acc.second.last - acc.second.first) / 2.0).toInt()
            'R' -> acc.first to acc.second.first + ceil((acc.second.last - acc.second.first) / 2.0).toInt()..acc.second.last
            else -> acc
        }
    }.let {
        it.first.first to it.second.first
    }
}

fun String.seatToInt() : Int {
    return this.subSequence(0..7).foldIndexed(0) {idx, acc, v -> if (v == 'B') acc + 2.0.pow(idx).toInt() else acc} * 8 +
            this.subSequence(8 until this.length).foldIndexed(0) { idx, acc, v -> if (v == 'R') acc + 2.0.pow(idx).toInt() else acc}
}