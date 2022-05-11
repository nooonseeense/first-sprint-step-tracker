import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        System.out.println("Добро пожаловать в «Счётчик калорий [Build 1.0]»!");
        while (true) {
            printMenu();
            int command = scanner.nextInt();
            if (command == 1) {
                stepTracker.enterTheNumOfStepsPerDay(scanner); // Вписываем значения, сохраняем в переменные
            } else if (command == 2) {
                stepTracker.outputUserMenu(scanner);
            } else if (command == 3) {
                stepTracker.defNumOfStepsChange(scanner);
            } else if (command == 4) {
                System.out.println("SYSTEM: <ВЫХОДИМ ИЗ ПРИЛОЖЕНИЯ...>");
                break;
            } else {
                System.out.println("SYSTEM: <ТАКОЙ КОМАНДЫ НЕ СУЩЕСТВУЕТ>");
                System.out.println("He said, Let's do this again. That's good, right?\n");
            }
        }
    }
    private static void printMenu() {
        System.out.println("Выберите команду из списка и нажмите Enter:");
        System.out.println("[1] - Ввести количество шагов за выбранный день");
        System.out.println("[2] - Напечатать статистику за выбранный месяц");
        System.out.println("[3] - Изменить цель по количеству шагов в день");
        System.out.println("[4] - Выйти из приложения");
    }
}
