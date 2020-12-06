package y2020.d06

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.map { it.joinToString(separator = "").toSet().size }.printResult()
}

fun b() {
    preparedInput.map {
        it.fold(it.first().toSet()) { acc, line ->  (acc intersect line.toSet()) }.size.also { s -> println(s) }
    }.printResult()
}