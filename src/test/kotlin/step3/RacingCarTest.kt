package step3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import racingcar.service.Car
import racingcar.service.RacingCar

class RacingCarTest {

    @Test
    fun racingCarTest() {
        // given
        val carNames = "a, b, c"
        val carList = carNames.split(", ").map { Car(it) }
        // when
        val racingCar = RacingCar(carList)
        // then
        assertEquals(racingCar.carList.size, 3)
        racingCar.carList.forEach {
            assertEquals(it.position, Car.START_POSITION)
        }
    }

    @ParameterizedTest
    @CsvSource(
        "'a', 1",
        "'a,b', 1",
        "'a,b,c', 1",
        "'a', 2",
        "'a,b', 2",
        "'a,b,c', 2",
        "'a', 3",
        "'a,b', 3",
        "'a,b,c', 3"
    )
    fun racingTest(input: String, numberOfRound: Int) {
        // given
        val carNames = input.split(", ")
        val carList = carNames.map { Car(it) }
        val racingCar = RacingCar(carList)
        // when
        racingCar.run(numberOfRound)
        // then
        assertEquals(carNames.size, racingCar.carList.size)
        racingCar.carList.forEach {
            assertTrue(it.position in 0..numberOfRound)
        }
    }

    @Test
    fun winnerTest() {
        // given
        val carList = listOf(Car("a", 0), Car("b", 1), Car("c", 2), Car("d", 2))
        val racingCar = RacingCar(carList)
        // when
        val winners = racingCar.getWinners()
        // then
        winners.forEach() {
            assertEquals(it.position, 2)
            assertTrue(it.name == "c" || it.name == "d")
        }
    }
}
