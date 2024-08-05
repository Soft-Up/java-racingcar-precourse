package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private final List<Car> cars;
	private Integer repeat;

	public Player() {
		this.cars = new ArrayList<>();
	}

	public void inputCars() {
		String input = Console.readLine();
		Validator validator = new Validator();
		validator.isValidCarsInput(input);

		String[] carNames = input.split(",");
		for (String carName : carNames) {
			cars.add(new Car(carName));
		}
	}

	public void inputRepeat() {
		String input = Console.readLine();

		Validator validator = new Validator();
		validator.isValidRepeatInput(input);

		repeat = Integer.parseInt(input);
	}

	public List<Car> getCars() {
		return cars;
	}

	public Integer getRepeat() {
		return repeat;
	}
}