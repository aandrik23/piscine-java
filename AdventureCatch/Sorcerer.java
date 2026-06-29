public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer (String name, int health, int heal, Weapon weapon){
        super(name,health, weapon);
        this.healCapacity = heal;
    }

    @Override
    public int getHealCapacity(){
        return this.healCapacity;
    }

    @Override
    public void heal(Character character) throws DeadCharacterException {

        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        if (character.getCurrentHealth() + healCapacity > character.getMaxHealth()) {
            character.setCurrentHealth(character.getMaxHealth());
        } else {
            character.setCurrentHealth(character.getCurrentHealth() + healCapacity);
        }
    }

    @Override
    public String toString() {
        String result;

        if (getCurrentHealth() > 0) {
            result = String.format("%s is a sorcerer with %d HP. It can heal %d HP.",
                    getName(), getCurrentHealth(), getHealCapacity());
        } else {
            result = String.format("%s is a dead sorcerer. So bad, it could heal %d HP.",
                    getName(), getHealCapacity());
        }

        if (getWeapon() != null) {
            result += " He has the weapon " + getWeapon().toString() + ".";
        }

        return result;
    }

    @Override
    public void attack(Character character) throws DeadCharacterException {

        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        heal(this);

        if (getWeapon() != null) {
            character.takeDamage(getWeapon().getDamage());
        } else {
            character.takeDamage(10);
        }
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {

        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        setCurrentHealth(getCurrentHealth() - damage);

        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }
}