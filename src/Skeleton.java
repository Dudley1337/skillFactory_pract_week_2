public class Skeleton extends Monster{
    public Skeleton() {
        setAgility(1);
        setGold(1);
        setExperience(1);
        setHealth(3);
        setStrength(1);
        System.out.println("Создан монстр-скелет");
    }

    @Override
    protected void move() {

    }

    @Override
    protected int attack() {
        return 0;
    }
}
