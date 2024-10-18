package card;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CardFactoryTest {
    @Test
    void create() {
        List<List<String>> list = new ArrayList<>();

        List<String> strings = new ArrayList<>();
        strings.add("asd");
        list.add(strings);
        list.add(strings);
        list.add(strings);
        list.add(strings);

        for (List<String> strs: list) {
            System.out.println(strs);
        }
        System.out.println();

        strings.add("123");
        for (List<String> strs: list) {
            System.out.println(strs);
        }
        System.out.println();
    }
}
