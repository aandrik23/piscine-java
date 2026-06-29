public class Monster extends Character {

    public Monster(String name, int maxHealth, Weapon weapon) {
        super(name, maxHealth, weapon);
    }

    @Override
    public void attack(Character character) throws DeadCharacterException {

        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        if (getWeapon() != null) {
            character.takeDamage(getWeapon().getDamage());
        } else {
            character.takeDamage(7);
        }
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {

        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        int realDamage = (int) (damage * 0.8);

        setCurrentHealth(getCurrentHealth() - realDamage);

        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }

    @Override
    public String toString() {
        String result;

        if (getCurrentHealth() == 0) {
            result = String.format("%s is a monster and is dead", getName());
        } else {
            result = String.format("%s is a monster with %d HP", getName(), getCurrentHealth());
        }

        if (getWeapon() != null) {
            result += ". He has the weapon " + getWeapon().toString() + ".";
        }

        return result;
    }
}