package y2020.d06

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.map {
        it.joinToString(separator = "").toSet().size
    }.printResult()
}

fun b() {
    preparedInput.map {
        it.map(String::toSet).reduce { acc, line -> acc intersect line.toSet()  }.size
    }.printResult()
}