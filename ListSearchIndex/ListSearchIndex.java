import java.util.ArrayList;
import java.util.List;

public class ListSearchIndex {
    public static Integer findFirstIndex(List<Integer> list, Integer value) {
        int index = list.indexOf(value);

        if (index == -1) {
            return null;
        }

        return index;
    }

    public static Integer findLastIndex(List<Integer> list , Integer value) {
        int index = list.lastIndexOf(value);

        if (index == -1) {
            return null;
        }
        return index;
    }

    public static List<Integer> findAllIndexes(List<Integer> list, Integer value) {
        List<Integer> indexes = new ArrayList<>(); {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals(value)) {
                    indexes.add(i);
                }
            }
            return indexes;
        }
    }
}


