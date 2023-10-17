import java.util.Scanner;
public class Main {

    public static Monster spawnMonster(){
        //рандомный 50/50 спавн противника
        if ((int)(Math.random()*2) == 0) return new Goblin();
        else return new Skeleton();
    }

    public static void startBattle(Entity player, Monster enemyMonster){

    }

    public static void printNavigation(){
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("New game");
        System.out.println("Создание Персонажа");
        System.out.println("Введите имя: ");
        //Entity Player1 = new Player(10,3,3, scanner.nextLine());
        Entity Player1 = new Player(10, 3, 3, "Player1");
        //Goblin goblin1 = new Goblin();*/
        printNavigation();
        boolean exitFlag = true;
        do {
            switch (scanner.nextLine()) {
                case "1": {
                    System.out.println("Торговец еще не приехал");
                    break;
                }
                case "2":{
                    System.out.println("Вы отправляетесь в темный лес...");
                    startBattle(Player1, spawnMonster());
                    System.out.println("Бой окончен");
                    printNavigation();
                    break;
                }
                case "3":{
                    exitFlag = false;
                    break;
                }
                case default:
                    System.out.println("Введите цифру строки выбора");
            }
       } while (exitFlag);
    }
}