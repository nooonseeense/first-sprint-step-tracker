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
    public void enterTheNumOfStepsPerDay(Scanner scanner) { // Ввод количества шагов за день
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            inputMonth = scanner.nextInt();
            System.out.println("Укажите номер дня в формате: 0 - [Первый день месяца]");
            inputDays = scanner.nextInt();
            System.out.println("Укажите количество пройденных шагов за выбранный период: ");
            inputSteps = scanner.nextInt();

            if (inputMonth < 0 || inputMonth >= 12 || inputDays < 0 ||
                    inputDays >= 30 || inputSteps < 0) {
                System.out.println("SYSTEM: <ВВЕДИТЕ ПОЛОЖИТЕЛЬНЫЕ ЧИСЛА>\n");
            } else {
                monthToData[inputMonth].daysMonth[inputDays] = inputSteps;
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
    public void outputUserMenu(Scanner scanner) { // Меню для вывода статистики приложения
        Converter convert = new Converter();
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            int inputMonthMethods = scanner.nextInt();
            int saveTotalSteps = totalNumOfStepsPerMonth(inputMonthMethods);

            if (inputMonthMethods < 0 || inputMonthMethods >= 12) {
                System.out.println("SYSTEM: <ВВЕДИТЕ ПОЛОЖИТЕЛЬНЫЕ ЧИСЛА>\n");
            } else {
                numOfStepsTakenPerDay(inputMonthMethods); // Количество пройденных шагов по дням
                System.out.println("[!] Общее количество шагов за месяц: \n" +
                        " " + totalNumOfStepsPerMonth(inputMonthMethods)); // Общее количество шагов за месяц
                maxNumOfStepsTakenInAMonth(inputMonthMethods); // Максимальное количество шагов
                avrNumOfSteps(inputMonthMethods); // Среднее количество шагов
                convert.distanceTraveled(saveTotalSteps); // Пройденная дистанция
                convert.calorieCalculator(saveTotalSteps);// Количество сожженых каллорий
                bestSeriesOfDays(defNumOfSteps);
                break;
            }
        }
    }
    public void defNumOfStepsChange(Scanner scanner) { // Изменение целового кол-ва шагов, не должно быть отрицательным
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
            System.out.println(" " + (i + 1) + " день: " +
                    monthToData[inputMonth].daysMonth[i] + "; ");
        }
    }
    public int totalNumOfStepsPerMonth(int inputMonth) {
        int sum = 0;
        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
            sum = sum + monthToData[inputMonth].daysMonth[i];
        }
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
        int sum = 0;
        int countZero = 0;

        for (int num : monthToData[inputMonth].daysMonth) {
            if (num > 0) {
                sum += num; // Посчитали сумму всех чисел
            } else if (num == 0) {
                countZero += 1;
            }
        }
        countZero = 30 - countZero;
        System.out.println("[!] Среднее количество шагов в месяце: \n" + " " + sum / countZero);
    }
    public void bestSeriesOfDays(int steps) {
        int countBestDays = 0;
        int maxCountBestDays = 0;

        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
            if (monthToData[inputMonth].daysMonth[i] < steps) {
                countBestDays = 0; // Серия дней [10000,10000,10000, 5]
            } else {
                countBestDays++;
                if (countBestDays >= maxCountBestDays) {
                    maxCountBestDays = countBestDays;
                }
            }
        }
        System.out.println("[!] Лучшая серия идущих подряд дней, когда шагов выше целевого: \n" +
                " " + maxCountBestDays);
    }
}
/*
* 1. Доделать метод bestSeriesOfDays;
* 2. Добавить проверку чисел в методы
* 3. Исправить ошибку: Проблема в методе avrNumOfSteps
* public void avrNumOfSteps(int inputMonth) {
        int sum = 0;
        int countZero = 0;

        for (int num : monthToData[inputMonth].daysMonth) {
            if (num > 0) {
                sum += num; // Посчитали сумму всех чисел
            } else if (num == 0) {
                countZero += 1;
            }
        }
        countZero = 30 - countZero;
        System.out.println("[!] Среднее количество шагов в месяце: \n" + " " + sum / countZero);
    }
* */