package racingcar.service

import kotlin.random.Random

class Car(val name: String, position: Int = START_POSITION) {
    var position: Int = position

    fun move() {
        if (isMovable()) {
            position++
        }
    }

    private fun isMovable(): Boolean {
        return Random.nextInt(MAX_RANDOM_NUMBER) >= ENABLE_TO_MOVE
    }

    companion object {
        const val START_POSITION = 0
        const val MAX_RANDOM_NUMBER = 10
        const val ENABLE_TO_MOVE = 4
    }
}
