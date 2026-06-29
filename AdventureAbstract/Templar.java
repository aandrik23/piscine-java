public class Templar extends Character implements Healer,Tank {
    private final int healCapacity;
    private final int shield;

    public Templar(String name, int health, int heal,int shield){
        super(name,health);
        this.healCapacity= heal;
        this.shield = shield;
    }

    @Override
    public int getHealCapacity(){
        return this.healCapacity;
    }

    @Override
    public void heal(Character character){
        if (getHealCapacity()+ character.getCurrentHealth() > character.getMaxHealth()){
            character.setCurrentHealth(character.getMaxHealth());
        } else {
            character.setCurrentHealth(character.getCurrentHealth() + this.healCapacity);
        }
    }

    @Override
    public int getShield(){
        return this.shield;
    }

    @Override
    public String toString(){
        if (getCurrentHealth() > 0){
            return String.format("%s is a strong Templar with %d HP. It can heal %d HP and has a shield of %d.",getName(),getCurrentHealth(), getHealCapacity(),getShield());
        }
        return String.format("%s has been beaten, even with its %d shield. So bad, it could heal %d HP.",getName(),getShield(),getHealCapacity());
    }


    @Override
    public void attack(Character character) {
        heal(this);
        character.takeDamage(6);
    }

    @Override
    public void takeDamage(int damage) {
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