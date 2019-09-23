package service;

import java.util.Random;

public class DiceRoller {
	public static int diceRoll() {
		return new Random().nextInt(6)+1;
	}
}
