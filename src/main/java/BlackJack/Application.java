package BlackJack;


import BlackJack.Controller.Controller;
import BlackJack.Model.Model;
import BlackJack.View.InputView;
import BlackJack.View.OutputView;


public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        Model model = new Model();
        OutputView output = new OutputView(model);
        Controller controller = new Controller(model, input, output);
        controller.gameStart();
    }
}