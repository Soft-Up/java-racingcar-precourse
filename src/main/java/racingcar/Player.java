package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
	public Player() {}

	public List<Car> inputCars() {
		List<Car> cars = new ArrayList<>();

		String input = Console.readLine();
		Validator validator = new Validator();
		validator.isValidCarsInput(input);

		String[] carNames = input.split(",");
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}

		return cars;
	}

	public Integer inputRepeat() {
		String input = Console.readLine();
		Validator validator = new Validator();
		validator.isValidRepeatInput(input);

		return Integer.parseInt(input);
	}
}