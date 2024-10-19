package BlackJack.Model;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Model {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();



    public String[][] randomPick(List<String> nameList) {
        String[][] cardBox = new String[nameList.size()][10];

        for (int i=0;i< nameList.size();i++) {
            for (int j=0;j<2;j++) {
                String name = cardName[random.nextInt(4)];
                String num = number[random.nextInt(12)];
                cardBox[i][j]=num+name;

            }
        }
        return cardBox;
    }

    public static void dealerPickCard(int i,String[][] cardBox,int j) {
        String name = cardName[random.nextInt(4)];
        String num = number[random.nextInt(12)];
        cardBox[i][j]=num+name;
    }
}