import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MapInventory {

    public static int getProductPrice(Map<String, Integer> inventory, String productId) {

        if (inventory == null || productId == null) {
            return -1;
        }

        Integer price = inventory.get(productId);

        if (price == null) {
            return -1;
        }

        return price;
    }

    public static List<String> getProductIdsByPrice(Map<String, Integer> inventory, int price) {

        List<String> products = new ArrayList<>();

        if (inventory == null) {
            return products;
        }

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            if (entry.getValue().equals(price)) {
                products.add(entry.getKey());
            }
        }

        return products;
    }
}
