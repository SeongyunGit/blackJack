package BlackJack.Model;


import BlackJack.Information.CardBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;



public class Model {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();
    public ArrayList<ArrayList<String>> cardBox;


    public ArrayList<ArrayList<String>> randomPick(List<String> nameList) {

        CardBox.getList(cardBox,nameList.size());

        for (int j=0;j<nameList.size();j++) {
            String name = cardName[random.nextInt(4)];
            String num = number[random.nextInt(12)];
            System.out.println(cardBox.get(j));
            cardBox.get(j).add(num+name);

        } return cardBox;
    }

    public static void dealerPickCard(int i,ArrayList<ArrayList<String>> cardBox) {
        String name = cardName[random.nextInt(4)];
        String num = number[random.nextInt(12)];
        cardBox.get(i).add(0,num+name);
    }

//    public static void randomCardPick(ArrayList<ArrayList<String>> cardBox, String card, int j) {
//        System.out.println("여기" + cardBox.get(j));
//        cardBox.get(j).add(card);
//    }


    public int randomCard(int number) {
        number = random.nextInt(number);
        return number;
    }
}