public class Goblin extends Monster {
    public Goblin() {
        setAgility(2);
        setGold(2);
        setExperience(3);
        setHealth(5);
        setStrength(2);
        System.out.println("Создан монстр-гоблин");
    }

    @Override
    protected void move() {

    }

    @Override
    protected int attack() {
        return 0;
    }
}

