package racingcar;

public class Car {
	private final String name;
	private Integer score;

	public Car(String name) {
		this.name = name;
		this.score = 0;
	}

	public String getName() {
		return name;
	}

	public Integer getScore() {
		return score;
	}

	public void increaseScore() {
		score += 1;
	}

	public static Integer compare(Car a, Car b) {
		return a.score.compareTo(b.score);
	}

	public String toString() {
		return name + " : " + "-".repeat(score);
	}
}