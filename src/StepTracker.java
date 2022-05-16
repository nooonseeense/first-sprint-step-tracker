import java.util.Scanner;

class StepTracker {
    private final Scanner SCANNER;
    private final MonthData[] MONTH_TO_DATA;
    private final Converter CONVERT = new Converter();
    private int defNumOfSteps = 10000;

    public StepTracker(Scanner SCANNER) {
        this.SCANNER = SCANNER;
        MONTH_TO_DATA = new MonthData[12];
        for (int i = 0; i < MONTH_TO_DATA.length; i++) {
            MONTH_TO_DATA[i] = new MonthData();
        }
    }
    public void enterTheNumOfStepsPerDay() {
        int inputMonth;
        int inputDays;
        int inputSteps;
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            inputMonth = SCANNER.nextInt();
            System.out.println("Укажите номер дня в формате: 1 - [Первый день месяца]");
            inputDays = SCANNER.nextInt();
            System.out.println("Укажите количество пройденных шагов за выбранный период: ");
            inputSteps = SCANNER.nextInt();
            if (inputMonth < 0 || inputMonth >= 12 || inputDays <= 0 ||
                    inputDays >= 31 || inputSteps < 0) {
                System.out.println("SYSTEM: <ОШИБКА ЧИСЛОВОГО ВВОДА>\n");
            } else {
                MONTH_TO_DATA[inputMonth].daysMonth[inputDays - 1] = inputSteps;
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
    public void outputUserMenu() {
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            int inputMonthMethods = SCANNER.nextInt();
            if (inputMonthMethods < 0 || inputMonthMethods >= 12) {
                System.out.println("SYSTEM: <ОШИБКА ЧИСЛОВОГО ВВОДА>\n");
            } else {
                int saveTotalSteps = totalNumOfStepsPerMonth(inputMonthMethods);
                numOfStepsTakenPerDay(inputMonthMethods);
                System.out.println("[!] Общее количество шагов за месяц: \n" +
                        " " + totalNumOfStepsPerMonth(inputMonthMethods));
                maxNumOfStepsTakenInAMonth(inputMonthMethods);
                avrNumOfSteps(inputMonthMethods);
                System.out.println("[!] Пройденная дистанция за месяц: \n" +
                        " " + CONVERT.distanceTraveled(saveTotalSteps) + " КМ");
                System.out.println("[!] Количество сожженых килокалорий: \n" +
                        " " + CONVERT.calorieCalculator(saveTotalSteps) + " KCAL");
                bestSeriesOfDays(defNumOfSteps, inputMonthMethods);
                break;
            }
        }
    }
    public void defNumOfStepsChange() {
        System.out.println("Текущее значение целевого количества шагов: " + defNumOfSteps);
        while (true) {
            System.out.println("Введите новое значение целевого количества шагов:");
            defNumOfSteps = SCANNER.nextInt();
            if (defNumOfSteps < 0) {
                System.out.println("SYSTEM: <ОШИБКА ЧИСЛОВОГО ВВОДА>\n");
            } else {
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
    public void numOfStepsTakenPerDay(int inputMonth) {
        System.out.println("[!] Количество пройденных шагов по дням:");
        for (int i = 0; i < MONTH_TO_DATA[inputMonth].daysMonth.length; i++) {
            System.out.println(" " + (i + 1) + " день: " +
                    MONTH_TO_DATA[inputMonth].daysMonth[i] + "; ");
        }
    }
    public int totalNumOfStepsPerMonth(int inputMonth) {
        int sum = 0;
        for (int i = 0; i < MONTH_TO_DATA[inputMonth].daysMonth.length; i++) {
            sum = sum + MONTH_TO_DATA[inputMonth].daysMonth[i];
        }
        return sum;
    }
    public void maxNumOfStepsTakenInAMonth(int inputMonth) {
        int num = 0;
        for (int i = 0; i < MONTH_TO_DATA[inputMonth].daysMonth.length; i++) {
            if (MONTH_TO_DATA[inputMonth].daysMonth[i] >= num) {
                num = MONTH_TO_DATA[inputMonth].daysMonth[i];
            }
        }
        System.out.println("[!] Максимальное пройденное количество шагов в месяце: \n" + " " + num);
    }
    public void avrNumOfSteps(int inputMonth) {
        int sum = 0;
        for (int i = 0; i < MONTH_TO_DATA[inputMonth].daysMonth.length; i++) {
                sum += MONTH_TO_DATA[inputMonth].daysMonth[i];
        }
        System.out.println("[!] Среднее количество шагов в месяце: \n" + " " +
                sum / MONTH_TO_DATA[inputMonth].daysMonth.length);
    }
    public void bestSeriesOfDays(int steps, int inputMonth) {
        int countBestDays = 0;
        int maxCountBestDays = 0;
        for (int i = 0; i < MONTH_TO_DATA[inputMonth].daysMonth.length; i++) {
            if (MONTH_TO_DATA[inputMonth].daysMonth[i] < steps) {
                countBestDays = 0;
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
