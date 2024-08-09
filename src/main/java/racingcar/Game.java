package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
	private final Player player;
	private List<Car> cars;
	private Integer repeat;

	public Game(Player player) {
		this.player = player;
	}

	public void start() {
		promptCarsInput();
		promptRepeatInput();

		printPlayAnnouncement();
		for (int i = 0; i < repeat; i++) {
			proceed();
			printCurrentScore();
		}

		List<Car> winners = selectWinners();
		printWinners(winners);
	}

	private void proceed() {
		for (Car car : cars) {
			if (Randoms.pickNumberInRange(0, 9) >= 4) {
				car.increaseScore();
			}
		}
	}

	private List<Car> selectWinners() {
		Integer max = cars.stream().max(Car::compare).orElseThrow().getScore();

		return cars.stream().filter(car -> car.getScore().equals(max)).collect(Collectors.toList());
	}

	private void promptCarsInput() {
		System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
		cars = player.inputCars();
	}

	private void promptRepeatInput() {
		System.out.println("시도할 회수는 몇회인가요?");
		repeat = player.inputRepeat();
	}

	private void printPlayAnnouncement() {
		System.out.println("실행 결과");
	}

	private void printCurrentScore() {
		for (Car car : cars) {
			System.out.println(car.toString());
		}
		System.out.println();
	}

	private void printWinners(List<Car> winners) {
		System.out.println("최종 우승자 : " + winners.stream().map(Car::getName).collect(Collectors.joining(", ")));
	}
}