package main.controller;

import java.util.Scanner;
import main.service.Service;
import main.util.GameMessage;
import main.view.View;

public class Controller {

	private final Service service;
	private final Scanner sc;

	public Controller() {
		service = new Service();
		sc = new Scanner(System.in);
	}

	public void run() {
		// 시작 메세지
		View.printGameIntro();
		// 실행 메소드 호출
		while (true) {
			playGame();
			if (!playAgain()) {
				break;
			}
		}
	}

	// 실행 메소드
	private void playGame() {
		service.createAnswer();
		System.out.println(service.createAnswer());
		while (true) {
			View.printUserInput();
			String input = sc.nextLine();
			String result = service.checkInput(input);
			System.out.println(result);

			if (service.isFinished()) {
				break;
			}
		}
	}

	// 재시작 여부 메세지
	private boolean playAgain() {
		View.printPlayAgain();
		int restartNum = Integer.parseInt(sc.nextLine());
		return restartNum == 1;
	}

}
