public abstract class Entity {
    protected int health, gold, agility, experience, strength;
    protected String name;

    protected abstract void move();
    //protected abstract void attack();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
    protected int attack(){
        //метод атаки с шансом успеха
        if (agility * 3 > (int)(Math.random()*(100+1))) return strength;
        else return  0;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "health=" + health +
                ", name='" + name + '\'' +
                '}';
    }
}
