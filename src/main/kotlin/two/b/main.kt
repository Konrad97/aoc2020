package two.b

import two.*

fun main() {
    getInput().count {
        (it.password[it.first - 1] == it.char) != (it.password[it.second - 1] == it.char)
    }.printResult()
}