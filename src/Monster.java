public abstract class Monster extends Entity {

    Monster(){
        System.out.println("Создан монстр-противник");
    }
    // @Override
    // protected void move(){}
     @Override
     public int attack(){
         if (agility * 3 > (int)(Math.random()*(100+1))) return strength;
         else return  0;
     }
}
