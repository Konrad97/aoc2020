package y2020.d07

fun main() {
    a()
    b()
}

fun a() {
    preparedInput.count { it.value.goldBags() > 0 }.printResult()
}

fun b() {
    (preparedInput["shiny gold"]!!.bags()).printResult()
}

fun Map<String, Int>.goldBags() : Int =
        map { preparedInput[it.key]!!.goldBags() * it.value }.sum() + filter { it.key == "shiny gold" }.map { it.value }.sum()

fun Map<String, Int>.bags() : Int =
    map { preparedInput[it.key]!!.bags() * it.value }.sum() + map { it.value }.sum()