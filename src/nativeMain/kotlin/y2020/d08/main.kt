package y2020.d08

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.exec().first.printResult()
}

fun b() {
    preparedInput.forEachIndexed { index, pair ->
        if (pair.first == "jmp") {
            preparedInput.toMutableList().let {
                it[index] = "nop" to pair.second
                it.exec().run {
                    if (second) {
                        first.printResult()
                        return
                    }
                }
            }
        }
    }
}

fun List<Pair<String, Int>>.exec(): Pair<Int, Boolean> {
    mutableSetOf<Int>().let { occurred ->
        var acc = 0
        var curr = 0
        while (!occurred.contains(curr)) {
            if (curr >= this.size) return acc to true
            occurred.add(curr)
            this[curr].let {
                when (it.first) {
                    "acc" -> {
                        acc += it.second
                        ++curr
                    }
                    "jmp" -> curr += it.second
                    else -> ++curr
                }
            }
        }
        return acc to false
    }
}