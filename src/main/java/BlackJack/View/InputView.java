package BlackJack.View;


import BlackJack.Information.MoneyList;
import BlackJack.Information.NameManager;


import java.util.*;
import java.util.stream.IntStream;

//import static BlackJack.Model.Model.randomCardPick;


public class InputView {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();
    private static final Scanner sc = new Scanner(System.in);
    private static final String INTRODUCE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String QUESTIONCARD = "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)";
    private static final String BETTINGMONEY = "의 베팅 금액은?";



    public static List<String> gameNameInput() {
        System.out.println(INTRODUCE);
        String input = sc.nextLine();
        NameManager nameManager = new NameManager(input);

        nameManager.addName("딜러");
        return nameManager.getNameList();
    }

    public static int chooseGettingCardInput(int noCount, int j, List<String> nameList, ArrayList<ArrayList<String>> cardBox) {
        System.out.println(nameList.get(j) + QUESTIONCARD);
        String answer = sc.next();
        if (answer.equals("y")) {
            String name = cardName[random.nextInt(4)];
            String num = number[random.nextInt(12)];
//            randomCardPick(cardBox,num + name,j);
        } else {
            noCount+=1;
        }
        return noCount;
    }

    public static List<Integer> bettingMoneyInput(List<String> nameList) {
        MoneyList moneyList = new MoneyList();

        moneyList.dealerMoney();

        IntStream.range(1,nameList.size()).forEach(i-> {
            System.out.println(nameList.get(i) + BETTINGMONEY);
            int money = sc.nextInt();
            moneyList.addMoney(money);
        });
        return moneyList.getMoneyList();
    }
}
