package BlackJack.View;

import java.util.*;
import java.util.stream.IntStream;

public class InputView {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();

    private static Scanner sc = new Scanner(System.in);

    public static List<String> gameNameInput() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = sc.nextLine();
        List<String> nameList = new ArrayList<>(Arrays.asList(input.split(",")));
        nameList.add(0,"딜러");
        return nameList;
    }

    public static int chooseGettingCardInput(int noCount, int j, List<String> nameList,ArrayList<ArrayList<String>> cardBox) {
        System.out.println(nameList.get(j) + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
        String answer = sc.next();
        if (answer.equals("y")) {
            String name = cardName[random.nextInt(4)];
            String num = number[random.nextInt(12)];
            cardBox.get(j).add(num + name);
        } else {
            noCount+=1;
        }
        return noCount;
    }

    public static List<Integer> bettingMoneyInput(List<String> nameList) {
        List<Integer> moneyList = new ArrayList<>();
        moneyList.add(0);
        IntStream.range(1,nameList.size()).forEach(i-> {
            System.out.println(nameList.get(i) + "의 베팅 금액은?");
            int money = sc.nextInt();
            moneyList.add(money);
        });
        return moneyList;
    }
}
