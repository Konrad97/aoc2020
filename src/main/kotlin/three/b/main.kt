package three.b

import three.preparedInput
import three.printResults

fun main() {
    listOf(
        preparedInput.traverse(1, 1),
        preparedInput.traverse(3, 1),
        preparedInput.traverse(5, 1),
        preparedInput.traverse(7, 1),
        preparedInput.traverse(1, 2)
    ).printResults()
}

fun List<List<Boolean>>.traverse(right: Int, down: Int): Int {
    return filterIndexed { idx, _ -> idx % down == 0 }
        .foldIndexed(0) { index, acc, list ->
            if (list[index * right % list.size]) acc + 1 else acc
        }
}