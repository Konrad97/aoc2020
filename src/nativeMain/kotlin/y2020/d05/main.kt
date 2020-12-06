package y2020.d05

fun main() {
    a()
    b()
}

fun a() =
    preparedInput.map(String::toID).maxOrNull()?.printResult()


fun b() =
    (preparedInput.map(String::toID).sorted().zipWithNext().first { it.second - it.first == 2 }.first + 1).printResult()


fun String.toID(): Int =
    fold(0) { acc, char ->
        when (char) {
            'B', 'R' -> (acc shl 1) or 1
            else -> acc shl 1
        }
    }