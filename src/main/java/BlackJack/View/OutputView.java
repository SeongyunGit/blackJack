package BlackJack.View;

import BlackJack.Information.CardBox;
import BlackJack.Model.Model;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static BlackJack.Model.Model.cardBox;
import static BlackJack.View.InputView.chooseGettingCardInput;


public class OutputView {

    private static final String DEALERGETONE = "딜러는 16이하라 한장의 카드를 더 받았습니다.";
    private static final String FINALRESULT = "## 최종 수익";

    private static final Random random = new Random();
    private static StringBuilder sb =new StringBuilder();
    private static Model model;

    public OutputView(Model model) {
        this.model = model;
    }


    public void showCardFirst(List<String> nameList) {
        System.out.println(cardBox);
        IntStream.range(1,nameList.size())
                .forEach(i-> {
                    sb.append(nameList.get(i));
                    if (i!= nameList.size()-1) {
                        sb.append(", ");
                    }
                });

        System.out.println("딜러와 " + sb +"에게 2장을 나누었습니다." );
        int bound = nameList.size();
        for (int i = 0; i < bound; i++) {
            List<String> result = cardBox.get(i);
            if (i == 0) {
                System.out.println(nameList.get(i) + ": " + cardBox.get(model.randomCard(2)));
            } else {
                System.out.println(nameList.get(i) + ": " + result);
            }
        }
    }

    public static void calculateTempoaryScore(List<String> nameList, CardBox cardBox) {
        while (true) {
            AtomicInteger noCount = new AtomicInteger(0);
            AtomicBoolean is_true = new AtomicBoolean(true);

            IntStream.range(0,nameList.size()).forEach(i-> {
                int count = cardBox.calculateNumber();

                if (count >= 21) {
                    is_true.set(false);
                    System.out.println(count);
                    return;
                }

                if (i == 0 && count < 16) {
                    System.out.println(DEALERGETONE);
                    model.dealerPickCard(cardBox);
                }
                if (i != 0 && count < 21) {
                    noCount.set(chooseGettingCardInput(noCount.get(), i, nameList,cardBox));
                }

            });

            if (!is_true.get() || noCount.get()==nameList.size()-1) {
                break;
            }
        }
    }
    public static void resultOutput(List<String> nameList, CardBox cardBox, ArrayList<Integer> result) {
        System.out.println(cardBox);
        List<Integer> scores = IntStream.range(0,nameList.size())
                .map(cardBox::calculatePlayerScore)
                .boxed()
                .collect(Collectors.toList());


        System.out.println(result);

        IntStream.range(0,nameList.size()).forEach(i-> {
            List<String> resultCard = cardBox.get(i);
            System.out.println(nameList.get(i) + ": " + resultCard + " - 결과: " + result.get(i));
        });
    }
    public static void lastBenefit(ArrayList<Integer> result,List<Integer> moneyList,List<String> nameList) {
        System.out.println(FINALRESULT);
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
