package two.a

import two.*

fun main() {
    getInput().count {
        it.password.count { char -> char == it.char } in it.first .. it.second
    }.printResult()
}