import java.util.ArrayList;
import java.util.List;

public class Character {
    private static List<Character> allCharacters = new ArrayList<>();
    private final String name;
    private final int maxHealth;
    private int currentHealth;

    public Character(String name, int maxHealth) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.currentHealth = maxHealth;

        allCharacters.add(this);
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public String toString() {
        if (currentHealth == 0) {
            return String.format("%s : KO", name);
        }

        return String.format("%s : %d/%d", name, currentHealth, maxHealth);
    }

    public void takeDamage(int damage) {
        currentHealth -= damage;

        if (currentHealth < 0) {
            currentHealth = 0;
        }
    }

    public void attack(Character character) {
        character.takeDamage(9);
    }

    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\n"
                    + "Nobody's fighting right now !\n"
                    + "------------------------------------------\n";
        }

        String result = "------------------------------------------\n"
                + "Characters currently fighting : \n";

        for (Character character : allCharacters) {
            result += " - " + character.toString() + "\n";
        }

        result += "------------------------------------------\n";
        return result;
    }

    public static Character fight(Character first, Character second) {
        while (first.getCurrentHealth() > 0 && second.getCurrentHealth() > 0) {

            first.attack(second);

            if (second.getCurrentHealth() == 0) {
                return first;
            }

            second.attack(first);

            if (first.getCurrentHealth() == 0) {
                return second;
            }
        }

        return null;
    }
}