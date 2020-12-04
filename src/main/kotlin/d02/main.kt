package d02


fun main() {
    a()
    b()
}

fun a() {
    getInput().count {
        it.password.count { char -> char == it.char } in it.first .. it.second
    }.printResult()
}

fun b() {
    getInput().count {
        (it.password[it.first - 1] == it.char) != (it.password[it.second - 1] == it.char)
    }.printResult()
}