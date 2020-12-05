package y2020.d04

fun main() {
    a()
    b()
}

fun a() {
    val requiredFields = setOf("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid")

    preparedInput.count { it.keys.containsAll(requiredFields) }.printResult()
}

fun b() {
    val requiredFields = mapOf<String, (String) -> Boolean>(
        "byr" to { it.length == 4 && it.toInt() in 1920..2002 },
        "iyr" to { it.length == 4 && it.toInt() in 2010..2020 },
        "eyr" to { it.length == 4 && it.toInt() in 2020..2030 },
        "hgt" to {
            when {
                it.endsWith("cm") -> it.dropLast(2).toInt() in 150..193
                it.endsWith("in") -> it.dropLast(2).toInt() in 59..76
                else -> false
            }
        },
        "hcl" to { it matches Regex("#[0-9|a-f]{6}") },
        "ecl" to { it in setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth") },
        "pid" to { it matches Regex("[0-9]{9}") },
    )

    preparedInput.count {
        requiredFields.entries.all { reqEntry -> it[reqEntry.key]?.run { reqEntry.value(this) } ?: false }
    }.printResult()

    "0123456789".toList().containsAll(listOf('a'))
}

