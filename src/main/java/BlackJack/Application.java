package BlackJack;


import java.util.*;

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
        String[] CardName = {"클로버","스페이드","하트","다이아몬드"};
        String[] number = {"A","1","2","3","4","5","6","7","8","9","J","Q","K"};

        for(int i=0;i< nameList.size();i++) {
            System.out.println(nameList.get(i) + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n");
            String answer=sc.nextLine();

        }
        System.out.println();
        Random random = new Random();



    }
}
