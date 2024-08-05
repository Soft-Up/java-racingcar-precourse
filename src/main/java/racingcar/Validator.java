package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Validator {
	public void isValidCarsInput(String input) {
		isValidCharacter(input);
		isValidNameLength(input);
		isDistinctName(input);
	}

	public void isValidRepeatInput(String input) {
		isNumber(input);
		isPositiveNumber(input);
	}

	// 1. 알파벳, 쉽표로만 구성됐는지
	private void isValidCharacter(String input) {
		if (!Pattern.matches("[a-zA-Z,]+", input)) {
			throw new IllegalArgumentException("입력은 알파벳과 쉼표로만 구성되어야 합니다.");
		}
	}

	// 2. 하나의 이름이 5글자 이하인지
	private void isValidNameLength(String input) {
		String[] names = input.split(",");
		for (String name : names) {
			if (name.length() > 5) {
				throw new IllegalArgumentException("이름은 5글자 이하이어야 합니다.");
			}
		}
	}

	// 3. 이름이 겹치지 않는지
	private void isDistinctName(String input) {
		List<String> originalList = Arrays.asList(input.split(","));
		List<String> distinctList = originalList.stream().distinct().toList();
		if (!originalList.equals(distinctList)) {
			throw new IllegalArgumentException("이름은 중복되지 않아야 합니다.");
		}
	}

	// 1. 숫자인지
	private void isNumber(String input) {
		if (!Pattern.matches("[0-9]+", input)) {
			throw new IllegalArgumentException("입력은 숫자여야 합니다.");
		}
	}

	// 2. 1 이상인지
	private void isPositiveNumber(String input) {
		int number = Integer.parseInt(input);
		if (number <= 0) {
			throw new IllegalArgumentException("숫자는 1 이상이어야 합니다.");
		}
	}
}


