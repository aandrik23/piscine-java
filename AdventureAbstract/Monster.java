public class Monster extends Character{
    public Monster(String name, int maxHealth) {
        super(name, maxHealth);
    }

    @Override
    public String toString() {
        if (getCurrentHealth() == 0) {
            return getName() + " is a monster and is dead";
        }
        return getName() + " is a monster with " + getCurrentHealth() + " HP";
    }

    @Override
    public void attack(Character character) {
        character.takeDamage(7);
    }

    @Override
    public void takeDamage(int damage) {
        int realDamage = (int) (damage * 0.8);
        setCurrentHealth(getCurrentHealth() - realDamage);

        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }
}