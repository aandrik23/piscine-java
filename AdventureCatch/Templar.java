public class Templar extends Character implements Healer,Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int maxHealth, int heal,int shield, Weapon weapon){
        super(name,maxHealth, weapon);
        this.healCapacity= heal;
        this.shield = shield;
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
    public int getShield(){
        return this.shield;
    }

    @Override
    public String toString(){
        String result;

        if (getCurrentHealth() == 0) {
            result = String.format(
                    "%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",
                    getName(),
                    getShield(),
                    getHealCapacity());
        } else {
            result = String.format(
                    "%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",
                    getName(),
                    getCurrentHealth(),
                    getHealCapacity(),
                    getShield());
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
            character.takeDamage(6);
        }
    }

    @Override
    public void takeDamage(int damage) throws DeadCharacterException {

        if (getCurrentHealth() == 0) {
            throw new DeadCharacterException(this);
        }

        int realDamage = damage - shield;

        if (realDamage < 0) {
            realDamage = 0;
        }

        setCurrentHealth(getCurrentHealth() - realDamage);

        if (getCurrentHealth() < 0) {
            setCurrentHealth(0);
        }
    }

}