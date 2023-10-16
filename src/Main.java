import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Создание Персонажа");
        System.out.println("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        //Entity Player1 = new Player(10,3,3, scanner.nextLine());
        Entity Player1 = new Player(10,3,3, "Player1");
    }
}