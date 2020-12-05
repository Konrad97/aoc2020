package y2020.d05

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.maxOrNull()!!.printResult()
}

fun b() {
    (preparedInput.sorted().zipWithNext().first { it.second - it.first == 2 }.first + 1).printResult()
}