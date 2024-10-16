package BlackJack.Information;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NameManager {
    private List<String> nameList;

    public NameManager(String input) {
        this.nameList = new ArrayList<>();
        splitInput(input);
    }

    private void splitInput(String input) {
        if (input != null && !input.isEmpty()) {
            this.nameList = new ArrayList<>(Arrays.asList(input.split(",")));
        }
    }

    public List<String> getNameList() {
        return this.nameList;
    }

    public void addName(String name) {
        this.nameList.add(0,name);
    }
}
