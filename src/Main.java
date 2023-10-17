import java.util.Scanner;
public class Main implements FightCallback{

    public static Monster spawnMonster(){
        //рандомный 50/50 спавн противника
        if ((int)(Math.random()*2) == 0) return new Goblin();
        else return new Skeleton();
    }
    //Метод боя
    public static void fight(Entity player, Entity monster, FightCallback fightCallback) {
        //Ходы будут идти в отдельном потоке
        Runnable runnable = () -> {
            //Сюда будем записывать, какой сейчас ход по счету
            int turn = 1;
            //Когда бой будет закончен мы
            boolean isFightEnded = false;
            while (!isFightEnded) {
                System.out.println("----Ход: " + turn + "----");
                //Воины бьют по очереди, поэтому здесь мы описываем логику смены сторон
                if (turn++ % 2 != 0) {
                    isFightEnded = makeHit(monster, player, fightCallback);
                } else {
                    isFightEnded = makeHit(player, monster, fightCallback);
                }
                try {
                    //Чтобы бой не проходил за секунду, сделаем имитацию работы, как если бы
                    //у нас была анимация
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        //Запускаем новый поток
        Thread thread = new Thread(runnable);
        thread.start();
    }
    //Метод для совершения удара
    private static Boolean makeHit(Entity defender, Entity attacker, FightCallback fightCallback) {
        //Получаем силу удара
        int hit = attacker.attack();
        System.out.println("Сила удара " + hit);
        //Отнимаем количество урона из здоровья защищающегося
        int defenderHealth = defender.getHealth() - hit;
        //Если атака прошла, выводим в консоль сообщение об этом
        if (hit != 0) {
            System.out.println(String.format("%s Нанес удар в %d единиц!", attacker.getName(), hit));
            System.out.println(String.format("У %s осталось %d единиц здоровья...", defender.getName(), defenderHealth));
        } else {
            //Если атакующий промахнулся (то есть урон не 0), выводим это сообщение
            System.out.println(String.format("%s промахнулся!", attacker.getName()));
        }
        if (defenderHealth <= 0 && defender instanceof Player) {
            //Если здоровье меньше 0 и если защищающейся был героем, то игра заканчивается
            System.out.println("Извините, вы пали в бою...");
            //Вызываем коллбэк, что мы проиграли
            fightCallback.fightLost();
            return true;
        } else if(defenderHealth <= 0) {
            //Если здоровья больше нет и защищающийся – это монстр, то мы забираем от монстра его опыт и золото
            System.out.println(String.format("Враг повержен! Вы получаете %d опыт и %d золота", defender.getExperience(), defender.getGold()));
            attacker.setExperience(attacker.getExperience() + defender.getExperience());
            attacker.setGold(attacker.getGold() + defender.getGold());
            //вызываем коллбэк, что мы победили
            fightCallback.fightWin();
            return true;
        } else {
            //если защищающийся не повержен, то мы устанавливаем ему новый уровень здоровья
            defender.setHealth(defenderHealth);
            return false;
        }
    }

    public static void startBattle(Entity player, Monster enemyMonster){
        fight(player, enemyMonster, new FightCallback() {
            @Override
            public void fightWin() {
                System.out.println(String.format("%s победил! Теперь у вас %d опыта и %d золота, а также осталось %d едениц здоровья.", player.getName(), player.getExperience(), player.getGold(), player.getHealth()));
                System.out.println("Желаете продолжить поход или вернуться в город? (да/нет)");
            }

            @Override
            public void fightLost() {
                System.out.println("fightLost");
            }
        });
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
        Entity Player1 = new Player(10, 30, 3, "Player1");
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

    @Override
    public void fightWin() {
        System.out.println("сработало перегрузка вторая победа");
    }

    @Override
    public void fightLost() {
        System.out.println("сработало перегрузка вторая поражение");
    }
}