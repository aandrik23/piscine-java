public class DeadCharacterException extends Exception {

    private final Character character;

    public DeadCharacterException(Character character) {
        this.character = character;
    }

    @Override
    public String getMessage() {

        if (character instanceof Sorcerer) {
            return "The sorcerer " + character.getName() + " is dead.";
        }

        if (character instanceof Monster) {
            return "The monster " + character.getName() + " is dead.";
        }

        if (character instanceof Templar) {
            return "The templar " + character.getName() + " is dead.";
        }

        return "The character " + character.getName() + " is dead.";
    }
}