package BlackJack.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Model {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();

    private static ArrayList<ArrayList<String>> cardBox = new ArrayList<>();

    public static ArrayList<ArrayList<String>> randomPick(List<String> nameList) {
        for (int i=0;i<2;i++) {
            for (int j=0; j<nameList.size();j++) {
                String name = cardName[random.nextInt(4)];
                String num = number[random.nextInt(12)];
                cardBox.get(j).add(num+name);
            }
        }
        return cardBox;
    }
    public static void dealerPickCard(int j, ArrayList<ArrayList<String>> cardBox) {
        String name = cardName[random.nextInt(4)];
        String num = number[random.nextInt(12)];
        cardBox.get(j).add(num + name);
    }
}
