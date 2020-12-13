package y2020.d13

fun main() {
    a()
    b()
}

fun a() {
    preparedInput
        .second
        .filterNotNull()
        .map { it to it - preparedInput.first % it }
        .minByOrNull { it.second }!!
        .printResult()
}

fun b() {

}