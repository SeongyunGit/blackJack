package BlackJack.Controller;

import BlackJack.Model.Model;
import BlackJack.View.InputView;
import BlackJack.View.OutputView;

import java.util.ArrayList;
import java.util.List;


public class Controller {
    private static List<String> nameList;
    private static List<Integer> moneyList = new ArrayList<>();
    private static ArrayList<ArrayList<String>> cardBox = new ArrayList<>();
    private static ArrayList<Integer> result = new ArrayList<>();

    private final Model model;
    private final InputView input;
    private final OutputView output;

    public Controller (Model model,InputView input, OutputView output) {
        this.model = model;
        this.input = input;
        this.output = output;
    }

    public void gameStart() {
        nameList = input.gameNameInput();
        moneyList = input.bettingMoneyInput(nameList);
        cardBox = model.randomPick(nameList,cardBox);
        output.showCardFirst(nameList,cardBox);
        System.out.println(cardBox);

        output.calculateTempoaryScore(nameList,cardBox);
        output.resultOutput(nameList, cardBox,result);

        System.out.println(cardBox);

        output.lastBenefit(result,moneyList,nameList);
    }
}
