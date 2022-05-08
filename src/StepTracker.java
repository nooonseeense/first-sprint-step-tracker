import java.util.Scanner;

class StepTracker {
    int defNumOfSteps = 10000; // Переменная с количеством шагов по умолчанию
    MonthData[] monthToData;
    int inputMonth = 0;
    int inputDays = 0;
    int inputSteps = 0;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void enterTheNumOfStepsPerDay() { // Ввод количества шагов за день
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            inputMonth = scanner.nextInt();

            System.out.println("Укажите номер дня в формате: 0 - [Первый день месяца]");
            inputDays = scanner.nextInt();

            System.out.println("Укажите количество пройденных шагов за выбранный период: ");
            inputSteps = scanner.nextInt();

            if (inputMonth < 0 && inputDays < 0 && inputSteps < 0) { // проверка на отрицатильные числа
                System.out.println("SYSTEM: <ВВЕДИТЕ ПОЛОЖИТЕЛЬНЫЕ ЧИСЛА>\n");
            } else {
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
//    public int saveSteps(MonthData[] monthToData, int months, int days, int steps) {
//
//
//    }

    public void outputUserMenu() { // Меню для вывода статистики приложения


    }

    public void defNumOfStepsChange() { // Изменение целового кол-ва шагов, не должно быть отрицательным
        Scanner scanner = new Scanner(System.in);

        System.out.println("Текущее значение целевого количества шагов: " + defNumOfSteps);

        while (true) {
            System.out.println("Введите новое значение целевого количества шагов:");
            defNumOfSteps = scanner.nextInt();

            if (defNumOfSteps < 0) {
                System.out.println("SYSTEM: <ВВЕДИТЕ ПОЛОЖИТЕЛЬНОЕ ЧИСЛО>\n");
            } else {
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
}

/*
    1. Объявить поля:
        1) Данные о шагах, пройденный в каждый день месяца Массив[30] дней, int кол-во шагов;
    2. inputUserMenu() - метод, куда пользователь будет вводить данные
    3. outputUserMenu() - метод, который будет обрабатывать все функции класса и выводить на экран пользователю
    4.
 */
