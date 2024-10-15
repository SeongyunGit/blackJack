package BlackJack.View;

import BlackJack.Model.Model;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
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
        IntStream.range(1,nameList.size())
                .forEach(i-> {
                    sb.append(nameList.get(i));
                    if (i!= nameList.size()-1) {
                        sb.append(", ");
                    }
                });


        System.out.println("딜러와 " + sb +"에게 2장을 나누었습니다." );
        IntStream.range(0, nameList.size()).forEach(i-> {
            String result = cardBox.get(i).stream()
                    .collect(Collectors.joining(", "));
            if (i==0) {
                System.out.println(nameList.get(i) + ": " + cardBox.get(i).get(random.nextInt(2)));
            } else {
                System.out.println(nameList.get(i) + ": " + result);
            }
        });
    }

    public static void calculateTempoaryScore(List<String> nameList,ArrayList<ArrayList<String>> cardBox) {
        while (true) {
            AtomicInteger noCount = new AtomicInteger(0);
            AtomicBoolean is_true = new AtomicBoolean(true);

            IntStream.range(0,nameList.size()).forEach(i-> {
                int count = cardBox.get(i).stream()
                        .mapToInt(card -> {
                            char firstChar = card.charAt(0);
                            if (firstChar == 'A') return 11;
                            else if (firstChar == 'K' || firstChar == 'Q' || firstChar == 'J') return 10;
                            else return firstChar - '0';
                        })
                        .sum();
                if (count >= 21) {
                    is_true.set(false);
                    System.out.println(count);
                    return;
                }

                if (i == 0 && count < 16) {
                    System.out.println("딜러는 16이하라 한장의 카드를 더 받았습니다.");
                    model.dealerPickCard(i, cardBox);
                }
                if (i != 0 && count < 21) {
                    noCount.set(chooseGettingCardInput(noCount.get(), i, nameList, cardBox));
                }

            });

            if (!is_true.get() || noCount.get()==nameList.size()-1) {
                break;
            }
        }
    }
    public static void resultOutput(List<String> nameList,ArrayList<ArrayList<String>> cardBox,ArrayList<Integer> result) {
        System.out.println(cardBox);
        List<Integer> scores = IntStream.range(0,nameList.size())
                .map(i-> cardBox.get(i).stream()
                        .mapToInt(card -> {
                            char firstChar =card.charAt(0);
                            if (firstChar=='A') return 11;
                            else if (firstChar=='K' || firstChar=='Q' || firstChar=='J') return 10;
                            else return firstChar-'0';
                        })
                        .sum())
                .boxed()
                .collect(Collectors.toList());
        result.addAll(scores);

        System.out.println(result);

        IntStream.range(0,nameList.size()).forEach(i-> {
            String resultCard = cardBox.get(i).stream()
                    .collect(Collectors.joining(", "));
            System.out.println(nameList.get(i) + ": " + resultCard + " - 결과: " + result.get(i));
        });
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
