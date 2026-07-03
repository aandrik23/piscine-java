import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class KeepTheChange {
    public static List<Integer> computeChange(int amount, Set<Integer> coins) {
        List<Integer> result = new ArrayList<>();

        if (coins == null || coins.isEmpty() || amount <= 0) {
            return result;
        }

        List<Integer> sortedCoins = new ArrayList<>(coins);
        Collections.sort(sortedCoins, Collections.reverseOrder());

        for (Integer coin : sortedCoins) {
            while (amount >= coin) {
                result.add(coin);
                amount -= coin;
            }
        }
        return result;
    }
}