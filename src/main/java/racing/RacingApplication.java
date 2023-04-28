package racing;

import java.util.List;
import racing.domain.GameResult;
import racing.domain.RacingGame;
import racing.domain.rule.RandomRacingRule;

import java.util.Scanner;
import racing.view.InputView;
import racing.view.RacingPrinter;

public class RacingApplication {
    public static void main(String[] args) {
        InputView inputView = new InputView(new Scanner(System.in));
        List<String> carNames = inputView.inputCarNames();
        int opportunity = inputView.inputOpportunity();

        RacingGame racingGame = new RacingGame(carNames, new RandomRacingRule());

        GameResult result = racingGame.start(opportunity);

        RacingPrinter.drawInitRound(carNames);
        RacingPrinter.drawEachRoundResult(result.getRoundResults());
        RacingPrinter.announceWinner(result.getWinners());
    }
}