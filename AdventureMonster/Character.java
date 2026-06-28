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

    @Override
    public String toString(){
        if (this.currentHealth == 0) {
            return String.format("%s : KO",this.name);
        }
        return String.format("%s : %d/%d",this.name,this.currentHealth,this.maxHealth);
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public int getCurrentHealth(){
        return this.currentHealth;
    }
    public String getName(){
        return this.name;
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

    public static void reset(){
        allCharacters.clear();
    }

    public static String printStatus() {
        if (allCharacters.isEmpty()) {
            return "------------------------------------------\nNobody's fighting right now !\n------------------------------------------\n";
        }

        StringBuilder status = new StringBuilder("------------------------------------------\nCharacters currently fighting :\n");
        for (Character character : allCharacters) {
            status.append(" - ").append(character.toString()).append("\n");
        }
        status.append("------------------------------------------\n");
        return status.toString();
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