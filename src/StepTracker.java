import java.util.Scanner;

class StepTracker {
    MonthData[] monthToData;

    int defNumOfSteps = 10000; // Переменная с количеством шагов по умолчанию
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
                monthToData[inputMonth].daysMonth[inputDays] = inputSteps;
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
    public void outputUserMenu(Scanner scanner) {
        Converter convert = new Converter();// Меню для вывода статистики приложения
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            int inputMonthMethods = scanner.nextInt();

            int saveTotalSteps = totalNumOfStepsPerMonth(inputMonthMethods);

            if (inputMonthMethods < 0 || inputMonthMethods > 30) {
                System.out.println("SYSTEM: <ЧИСЛО ДОЛЖНО БЫТЬ БОЛЬШЕ ИЛИ РАВНО 0 И МЕНЬШЕ 31>\n");
            } else {
                numOfStepsTakenPerDay(inputMonthMethods); // Количество пройденных шагов по дням
                totalNumOfStepsPerMonth(inputMonthMethods); // Общее количество шагов за месяц
                maxNumOfStepsTakenInAMonth(inputMonthMethods); // Максимальное количество шагов
                avrNumOfSteps(inputMonthMethods); // Среднее количество шагов
                convert.distanceTraveled(saveTotalSteps); // Пройденная дистанция
                convert.calorieCalculator(saveTotalSteps);// Количество сожженых каллорий
                break;
            }
        }// Лучшая серия: максимальное количество подряд идущих дней, в течение которых количество шагов за день было равно или выше целевого.
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
    public void numOfStepsTakenPerDay(int inputMonth) {
        System.out.println("[!] Количество пройденных шагов по дням:");
        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
            System.out.println(" " + (i + 1) + " день: " + monthToData[inputMonth].daysMonth[i] + "; ");
        }
    }
    public int totalNumOfStepsPerMonth(int inputMonth) {
        int sum = 0;
        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
            sum = sum + monthToData[inputMonth].daysMonth[i];
        }
        System.out.println("[!] Общее количество шагов за месяц: \n" + " " + sum);
        return sum;
    }
    public void maxNumOfStepsTakenInAMonth(int inputMonth) {
        int num = 0;
        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
            if (monthToData[inputMonth].daysMonth[i] >= num) {
                num = monthToData[inputMonth].daysMonth[i];
            }
        }
        System.out.println("[!] Максимальное пройденное количество шагов в месяце: \n" + " " + num);
    }
    public void avrNumOfSteps(int inputMonth) {
        int avr = 0;
        if (monthToData[inputMonth].daysMonth.length > 0) {
           int sum = 0;
           int index = 0;

            for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
                if (monthToData[inputMonth].daysMonth[i] == 0) {
                    index += 1;
                }
            }
            index = monthToData[inputMonth].daysMonth.length - index;

            for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
                    sum += monthToData[inputMonth].daysMonth[i];
            }
            avr = sum / index;
        }
        System.out.println("[!] Среднее количество шагов в месяце: \n" + " " + avr);
    }
}

/*
    1. Объявить поля:
        1) Данные о шагах, пройденный в каждый день месяца Массив[30] дней, int кол-во шагов;
    2. inputUserMenu() - метод, куда пользователь будет вводить данные
    3. outputUserMenu() - метод, который будет обрабатывать все функции класса и выводить на экран пользователю
    4.
 */
