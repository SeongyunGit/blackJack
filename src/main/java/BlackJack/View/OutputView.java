package BlackJack.View;

import BlackJack.Model.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static BlackJack.View.InputView.chooseGettingCardInput;


public class OutputView {

    private static final Random random = new Random();
    private static StringBuilder sb =new StringBuilder();
    private static Model model;

    public OutputView(Model model) {
        this.model = model;
    }

    public void showCardFirst(List<String> nameList, ArrayList<ArrayList<String>> cardBox) {
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

    public static void calculateTempoaryScore(List<String> nameList,ArrayList<ArrayList<String>> cardBox) {
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
                    model.dealerPickCard(j,cardBox);
                }

                if (j != 0 && count < 21) {
                    noCount = chooseGettingCardInput(noCount,j,nameList,cardBox);


                }
            }
            if (!is_true || noCount==nameList.size()-1) {
                break;
            }
        }
    }
    public static void resultOutput(List<String> nameList,ArrayList<ArrayList<String>> cardBox,ArrayList<Integer> result) {
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
    public static void lastBenefit(ArrayList<Integer> result,List<Integer> moneyList,List<String> nameList) {
        System.out.println("## 최종 수익");
        int [] ranking = new int[result.size()];

        IntStream.range(0,result.size()).forEach(i-> {
            int rank = (int) IntStream.range(0,result.size())
                    .filter( j->result.get(i) < result.get(j) && result.get(j) <= 21 || result.get(i)>21)
                    .count()+1;
            ranking[i]=rank;
        });

        IntStream.range(0,result.size())
                .filter(i->result.get(i) > 21)
                .forEach(i->ranking[i]=2);

        System.out.println(Arrays.toString(ranking));
        int[] realResult = new int[result.size()];
        IntStream.range(0,ranking.length).forEach(i-> {
            if (ranking[i] == 1) {
                realResult[i] = moneyList.get(i);
            } else {
                realResult[i] = -moneyList.get(i);
            }
        });

        int dealer = 0;
        dealer += IntStream.range(1,moneyList.size())
                .map(i->realResult[i])
                .sum();

        realResult[0] = -dealer;
        IntStream.range(0,moneyList.size())
                .forEach(i-> System.out.println(nameList.get(i) + ": " + realResult[i]));

    }
}
