package BlackJack;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> nameList = Arrays.asList(input.split(","));

        List<Integer> moneyList = new ArrayList<>();
        for (int i=0;i< nameList.size();i++) {
            System.out.println(nameList.get(i) + "의 베팅 금액은?");
            moneyList.add(sc.nextInt());
        }


    }
}
