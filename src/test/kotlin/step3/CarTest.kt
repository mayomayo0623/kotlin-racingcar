package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import racingcar.service.Car

class CarTest {

    @Test
    fun carTest() {
        // given
        val name = "test"
        val startPosition = Car.START_POSITION
        // when
        val car = Car("test")
        // then
        assertEquals(car.name, name)
        assertEquals(car.position, startPosition)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9])
    fun carMoveTest(input: Int) {
        // given
        val car = Car("test")
        // when
        repeat(input) {
            car.move()
        }
        // then
        assertTrue(car.position in 0..input)
    }
}
