package BlackJack.Model;

import BlackJack.Information.CardBox;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Model {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();


    public static CardBox randomPick(List<String> nameList) {
        CardBox cardBox = new CardBox();
        cardBox.getList(nameList.size());


        IntStream.range(0,2).forEach(i->
                IntStream.range(0, nameList.size()).forEach(j-> {
                    String name = cardName[random.nextInt(4)];
                    String num = number[random.nextInt(12)];
                    cardBox.getRandomNumber(num+name,j);
                })
        );
        return cardBox;
    }
    public static void dealerPickCard(int j, CardBox cardBox) {
        String name = cardName[random.nextInt(4)];
        String num = number[random.nextInt(12)];
        cardBox.getRandomNumber(num+name,j);
    }


    public void randomCard(int number) {

    }
}