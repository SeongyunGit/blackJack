package BlackJack.Information;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.List;

public class Result {

    public static void resultCalculate(ArrayList<Integer> result, String[][] cardBox, List<String> nameList) {
        for (int i=0;i<nameList.size();i++) {
            int total=0;
            for (String j : cardBox[i]) {
                if (j == null) {
                    break;
                } else {
                    Card card = new Card(j);
                    total += card.getValue();
                }
            }
            result.add(total);
        }
        System.out.println("result" + result);
    }
}
