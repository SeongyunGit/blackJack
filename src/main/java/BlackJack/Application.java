package BlackJack;


import java.util.*;

public class Application {

    private static final String[] cardName = {"클로버","스페이드","하트","다이아몬드"};
    private static final String[] number = {"A","2","3","4","5","6","7","8","9","J","Q","K"};
    private static final Random random = new Random();

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<ArrayList<String>> cardBox = new ArrayList<>();
    private static List<Integer> moneyList = new ArrayList<>();
    private static StringBuilder sb =new StringBuilder();
    private static List<String> nameList = new ArrayList<>();
    private static ArrayList<Integer> result = new ArrayList<>();
    private static int[] ranking;

    public static void main(String[] args) {

        nameList = gameNameInput();

        moneyList = bettingMoney(nameList);

        cardBox = randomPick(nameList);

        showCardFirst(nameList);
        System.out.println(cardBox);

        calculateTempoaryScore();

        resultOutput();

        System.out.println(cardBox);

        lastBenefit();
    }


    static List<String> gameNameInput() {
        System.out.println("게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)");
        String input = sc.nextLine();
        List<String> nameList = new ArrayList<>(Arrays.asList(input.split(",")));
        nameList.add(0,"딜러");
        System.out.println(nameList);
        return nameList;
    }

    static List<Integer> bettingMoney(List<String> nameList) {
        for (int i=0;i< nameList.size();i++) {
            ArrayList<String> list = new ArrayList<>();
            cardBox.add(list);
        }
        List<Integer> moneyList = new ArrayList<>();
        moneyList.add(0);
        for (int i=1;i<nameList.size();i++) {
            System.out.println(nameList.get(i) + "의 베팅 금액은?");
            int money = sc.nextInt();
            moneyList.add(money);
        }
        return moneyList;
    }

    static int chooseGettingCardInput(int noCount, int j, List<String> nameList) {
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

    static ArrayList<ArrayList<String>> randomPick(List<String> nameList) {
        for (int i=0;i<2;i++) {
            for (int j=0; j<nameList.size();j++) {
                String name = cardName[random.nextInt(4)];
                String num = number[random.nextInt(12)];
                cardBox.get(j).add(num+name);
            }
        }
        return cardBox;
    }

    static void showCardFirst(List<String> nameList) {
        System.out.println(cardBox);
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
    }
    static void calculateTempoaryScore() {
        while (true) {
            int noCount = 0;
            boolean is_true = true;

            for (int j=0; j<nameList.size();j++) {
                int count = 0;
                for (int l = 0; l < cardBox.get(j).size(); l++) {
                    if (cardBox.get(j).get(l).charAt(0) == 'A') {
                        count += 11;
                    } else if (cardBox.get(j).get(l).charAt(0) == 'K' || cardBox.get(j).get(l).charAt(0) == 'Q' || cardBox.get(j).get(l).charAt(0) == 'J') {
                        count += 10;
                    } else {
                        count +=cardBox.get(j).get(l).charAt(0)-'0';
                    }
                }
                if (count>=21) {
                    is_true=false;
                    System.out.println(count);
                    break;
                }
                if (j == 0 && count <= 16) {
                    System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
                    String name = cardName[random.nextInt(4)];
                    String num = number[random.nextInt(12)];
                    cardBox.get(j).add(num + name);
                }
                if (j != 0 && count < 21) {
                    noCount = chooseGettingCardInput(noCount,j,nameList);


                }
            }
            if (!is_true || noCount==nameList.size()-1) {
                break;
            }
        }
    }

    static void resultOutput() {
        System.out.println(cardBox);
        for (int j=0; j<nameList.size();j++) {
            int count = 0;
            for (int l = 0; l < cardBox.get(j).size(); l++) {
                if (cardBox.get(j).get(l).charAt(0) == 'A') {
                    count += 11;
                } else if (cardBox.get(j).get(l).charAt(0) == 'K' || cardBox.get(j).get(l).charAt(0) == 'Q' || cardBox.get(j).get(l).charAt(0) == 'J') {
                    count += 10;
                } else {
                    count += cardBox.get(j).get(l).charAt(0) - '0';
                }
            }
            result.add(count);
        }
        System.out.println(result);
        for (int i=0;i< nameList.size();i++) {
            String resultCard = "";
            for (int j=0; j< cardBox.get(i).size();j++) {
                resultCard+=cardBox.get(i).get(j);
                if (j<cardBox.get(i).size()-1) {
                    resultCard+=", ";
                }
            }
            System.out.println(nameList.get(i) + ": " + resultCard + " - 결과: " + result.get(i));
        }
    }

    static void lastBenefit() {
        System.out.println("## 최종 수익");
        ranking = new int[result.size()];
        for (int i =0;i< result.size();i++) {
            int rank = 1;
            for (int j=0;j< result.size();j++) {
                if (result.get(i)>21) {
                    rank++;
                }
                else if (result.get(i)<result.get(j) && result.get(j)<=21) {
                    rank++;
                }
            }
            ranking[i]=rank;
        }
        for (int i=0;i< result.size();i++) {
            if (result.get(i)>21) {
                ranking[i]=2;
            }
        }


        System.out.println(Arrays.toString(ranking));
        int[] realResult=new int[result.size()];
        for (int i=0;i< ranking.length;i++) {
            if (ranking[i]==1) {
                realResult[i]=moneyList.get(i);
            }
            else {
                realResult[i]=-moneyList.get(i);
            }
        }

        int dealer=0;
        for (int i=1;i< moneyList.size();i++) {
            dealer+=realResult[i];
        }
        realResult[0]=-dealer;
        for (int i=0;i< moneyList.size();i++) {
            System.out.println(nameList.get(i) + ": " + realResult[i]);
        }
    }
}
