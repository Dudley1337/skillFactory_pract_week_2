public class Player extends Entity {

    Player (int health, int agility, int strength, String name){
        setHealth(health);
        setAgility(agility);
        setStrength(strength);
        setGold(10);
        setExperience(0);
        setName(name);
        System.out.println("Создан персонаж игрока под именем " + getName() + " со следующими параметрами:\n" +
        "Сила: " + getStrength() + "\n" +
        "Ловкость: " + getAgility() + "\n" +
        "Золото: " + getGold());
    }
    @Override
    public void move(){

    }
    @Override
    public int attack(){
        if (agility * 3 > (int)(Math.random()*(100+1))) return strength;
        else return  0;
    }
}
