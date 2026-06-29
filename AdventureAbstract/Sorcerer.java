public class Sorcerer extends Character implements Healer {
    private final int healCapacity;

    public Sorcerer (String name, int health, int heal){
        super(name,health);
        this.healCapacity = heal;
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
    public String toString(){
        if (getCurrentHealth() > 0){
            return String.format("%s is a sorcerer with %d HP. It can heal %d HP.",getName(),getCurrentHealth(), getHealCapacity());
        }
        return String.format("%s is a dead sorcerer. So bad, it could heal %d HP.",getName(),getHealCapacity());
    }

}