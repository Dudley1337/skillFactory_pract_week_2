public class Skeleton extends Monster{
    //Контруктор монстра статический, но можно и сделать параметрический
    public Skeleton() {
        setAgility(25);
        setGold(1);
        setExperience(1);
        setHealth(3);
        setStrength(1);
        setName("Скелетон");
        System.out.println("Создан монстр-скелет");
    }

    @Override
    protected void move() {

    }

    @Override
    public int attack(){
        if (agility * 3 > (int)(Math.random()*(100+1))) return strength;
        else return  0;
    }
}
