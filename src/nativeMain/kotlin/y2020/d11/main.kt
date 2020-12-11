package y2020.d11

fun main() {
    a()
    b()
}

fun a() {
    var currentIteration = preparedInput
    var nextIteration = preparedInput.step()
    while (currentIteration != nextIteration) {
        currentIteration = nextIteration
        nextIteration = nextIteration.step()
    }
    currentIteration.flatten().count { it.second }.printResult()
}

fun b() {
    var currentIteration = preparedInput
    var nextIteration = preparedInput.stepOnSight()
    while (currentIteration != nextIteration) {
        currentIteration = nextIteration
        nextIteration = nextIteration.stepOnSight()
    }
    currentIteration.flatten().count { it.second }.printResult()
}

fun List<List<Pair<Boolean, Boolean>>>.step(): List<List<Pair<Boolean, Boolean>>> {
    return this.mapIndexed { rowIdx, row ->
        row.mapIndexed { columnIdx, cell ->
            cell.first to if (cell.first) {
                (-1..1).map { x ->
                    (-1..1).map { y ->
                        if (x == 0 && y == 0) false else this.getOrNull(rowIdx + x)?.getOrNull(columnIdx + y)?.second
                            ?: false
                    }
                }.flatten().count { it }.let { occupancy ->
                    when {
                        cell.second && occupancy >= 4 -> false
                        !cell.second && occupancy == 0 -> true
                        else -> cell.second
                    }
                }
            } else false
        }
    }
}

fun List<List<Pair<Boolean, Boolean>>>.stepOnSight(): List<List<Pair<Boolean, Boolean>>> {
    return this.mapIndexed { rowIdx, row ->
        row.mapIndexed { columnIdx, cell ->
            cell.first to if (cell.first) {
                (-1..1).map { x ->
                    (-1..1).map { y ->

                        if (x == 0 && y == 0) false else travelUntilSeat(rowIdx to columnIdx, x to y)
                    }
                }.flatten().count { it }.let { occupancy ->
                    when {
                        cell.second && occupancy >= 5 -> false
                        !cell.second && occupancy == 0 -> true
                        else -> cell.second
                    }
                }
            } else false
        }
    }
}

fun List<List<Pair<Boolean, Boolean>>>.travelUntilSeat(pos: Pair<Int,Int>, dir: Pair<Int, Int>) : Boolean {
    val nextPos = pos.first + dir.first to pos.second + dir.second
    return this.getOrNull(nextPos.first)?.getOrNull(nextPos.second)?.let { if(it.first) it.second else this.travelUntilSeat(nextPos, dir) } ?: false
}

fun <E> List<E>.getOrNull(index: Int): E? {
    return try {
        this[index]
    } catch (e: IndexOutOfBoundsException) {
        null
    }
}