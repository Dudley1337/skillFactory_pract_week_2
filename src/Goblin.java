public class Goblin extends Monster {
    //Контруктор монстра статический, но можно и сделать параметрический
    public Goblin() {
        setAgility(20);
        setGold(2);
        setExperience(3);
        setHealth(5);
        setStrength(2);
        setName("Гоблин");
        System.out.println("Создан монстр-гоблин");
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

