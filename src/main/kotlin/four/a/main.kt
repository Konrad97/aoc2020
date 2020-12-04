package four.a

import four.preparedInput
import four.printResult


val requiredFields = listOf(
    "byr",
    "iyr",
    "eyr",
    "hgt",
    "hcl",
    "ecl",
    "pid"
)

fun main() {
    preparedInput.count { requiredFields.all { requiredField -> requiredField in it } }.printResult()
}