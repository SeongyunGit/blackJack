package BlackJack;


import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<String> nameList = new ArrayList<>(Arrays.asList(input.split(",")));
        nameList.add(0,"딜러");
        System.out.println(nameList);

        ArrayList<ArrayList<String>> cardBox = new ArrayList<>();
        for (int i=0;i< nameList.size();i++) {
            ArrayList<String> list = new ArrayList<>();
            cardBox.add(list);
        }
        List<Integer> moneyList = new ArrayList<>();
        for (int i=1;i<nameList.size();i++) {
            System.out.println(nameList.get(i) + "의 베팅 금액은?");
            int money = sc.nextInt();
            moneyList.add(money);
        }

        String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
        String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
        Random random = new Random();

        for (int i=0;i<2;i++) {
            for (int j=0; j<nameList.size();j++) {
                String name = cardName[random.nextInt(4)];
                String num = number[random.nextInt(12)];
                cardBox.get(j).add(num+name);
            }
        }

        System.out.println(cardBox);
        StringBuilder sb =new StringBuilder();
        for (int i=1;i< nameList.size();i++) {
            sb.append(nameList.get(i));
            if (i!= nameList.size()-1) {
                sb.append(", ");
            }
        }

        System.out.println("딜러와 " + sb +"에게 2장을 나누었습니다." );
        for (int i=0;i< nameList.size();i++) {
            String result = "";
            for (int j=0; j< cardBox.get(i).size();j++) {
                result+=cardBox.get(i).get(j);
                if (j<cardBox.get(i).size()-1) {
                    result+=", ";
                }
            }
            if (i==0) {
                System.out.println(nameList.get(i) + ": " + cardBox.get(i).get(random.nextInt(2)));
            } else {
                System.out.println(nameList.get(i) + ": " + result);
            }

        }
        
        for (int j=1; j<nameList.size();j++) {
            System.out.println(nameList.get(j) + "는 한장의 카드를 더 받겠습니까? (예는 y, 아니오는 n)");
            String answer = sc.next();
            if (answer.equals("y")) {
                String name = cardName[random.nextInt(4)];
                String num = number[random.nextInt(12)];
                cardBox.get(j).add(num+name);
            }
        }


    }
}
