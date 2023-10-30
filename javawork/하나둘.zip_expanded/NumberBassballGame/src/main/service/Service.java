package main.service;

import java.util.ArrayList;
import java.util.List;

import main.domain.Result;
import main.util.GameMessage;
import main.validation.Validation;

public class Service {

	boolean restart = false;

	// 랜덤한 수 생성
	List<Integer> answerList;

	public List<Integer> createAnswer() {
		answerList = new ArrayList<>();

		while (answerList.size() < 3) {
			int randomNumber = (int) (Math.random() * 9) + 1;
			if (!answerList.contains(randomNumber)) {
				answerList.add(randomNumber);
			}
		}
		return answerList;
	}

	public String checkInput(String input) {

		// 입력값 체크 문제 시 Exception
		Validation.NumberCheck(input);

		List<Integer> inputList = new ArrayList<>();
		inputList.add(Integer.parseInt(input.substring(0, 1)));
		inputList.add(Integer.parseInt(input.substring(1, 2)));
		inputList.add(Integer.parseInt(input.substring(2, 3)));

		int strikes = 0;
		int balls = 0;

		for (int i = 0; i < answerList.size(); i++) {
			int inputDigit = inputList.get(i);
			int answerDigit = answerList.get(i);

			if (inputDigit == answerDigit) {
				strikes++;
			} else if (answerList.contains(inputDigit)) {
				balls++;
			}
		}

		Result result = new Result(balls, strikes);

		if (result.isGameWon()) {
			restart = true;
			return result.getResultMessage() + "\n" + GameMessage.GAME_CLEAR_MESSAGE;
		}
		restart = false;
		return result.getResultMessage();
	}

	public boolean isFinished() {
		return restart;
	}

}
