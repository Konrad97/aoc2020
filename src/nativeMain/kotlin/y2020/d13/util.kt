package y2020.d13

fun Pair<Int, Int>.printResult() = println("The result is: ${this.first} * ${this.second} = ${this.first* this.second}")

val preparedInput: Pair<Int, List<Int?>> by lazy {
    input.lines().first().toInt() to input.lines()[1].split(",").map { if (it == "x") null else it.toInt() }
}

private const val input = """1002460
29,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,41,x,x,x,x,x,x,x,x,x,601,x,x,x,x,x,x,x,23,x,x,x,x,13,x,x,x,17,x,19,x,x,x,x,x,x,x,x,x,x,x,463,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,x,37"""