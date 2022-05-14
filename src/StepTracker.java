import java.util.Scanner;

class StepTracker {
    private Scanner scanner;
    private MonthData[] monthToData;
    private Converter convert = new Converter();
    private int defNumOfSteps = 10000;

    public StepTracker() {
        scanner = new Scanner(System.in);
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void enterTheNumOfStepsPerDay() {
        int inputMonth;
        int inputDays;
        int inputSteps;
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            inputMonth = scanner.nextInt();
            System.out.println("Укажите номер дня в формате: 1 - [Первый день месяца]");
            inputDays = scanner.nextInt();
            System.out.println("Укажите количество пройденных шагов за выбранный период: ");
            inputSteps = scanner.nextInt();
            if (inputMonth < 0 || inputMonth >= 12 || inputDays < 0 ||
                    inputDays >= 31 || inputSteps < 0) {
                System.out.println("SYSTEM: <ВВЕДИТЕ ПОЛОЖИТЕЛЬНЫЕ ЧИСЛА>\n");
            } else {
                monthToData[inputMonth].daysMonth[inputDays - 1] = inputSteps;
                System.out.println("SYSTEM: <ДАННЫЕ СОХРАНЕНЫ>\n");
                break;
            }
        }
    }
    public void outputUserMenu() {
        while (true) {
            System.out.println("Укажите номер месяца в формате: 0 - [Январь]:");
            int inputMonthMethods = scanner.nextInt();
            int saveTotalSteps = totalNumOfStepsPerMonth(inputMonthMethods);
            if (inputMonthMethods < 0 || inputMonthMethods >= 12) {
                System.out.println("SYSTEM: <ВВЕДИТЕ ПОЛОЖИТЕЛЬНЫЕ ЧИСЛА>\n");
            } else {
                numOfStepsTakenPerDay(inputMonthMethods);
                System.out.println("[!] Общее количество шагов за месяц: \n" +
                        " " + totalNumOfStepsPerMonth(inputMonthMethods));
                maxNumOfStepsTakenInAMonth(inputMonthMethods);
                avrNumOfSteps(inputMonthMethods);
                System.out.println("[!] Пройденная дистанция за месяц: \n" +
                        " " + convert.distanceTraveled(saveTotalSteps) + " КМ");
                System.out.println("[!] Количество сожженых килокалорий: \n" +
                        " " + convert.calorieCalculator(saveTotalSteps) + " KCAL");
                bestSeriesOfDays(defNumOfSteps, inputMonthMethods);
                break;
            }
        }
    }
    public void defNumOfStepsChange() {
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
        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
                sum += monthToData[inputMonth].daysMonth[i];
        }
        System.out.println("[!] Среднее количество шагов в месяце: \n" + " " +
                sum / monthToData[inputMonth].daysMonth.length);
    }
    public void bestSeriesOfDays(int steps, int inputMonth) {
        int countBestDays = 0;
        int maxCountBestDays = 0;
        for (int i = 0; i < monthToData[inputMonth].daysMonth.length; i++) {
            if (monthToData[inputMonth].daysMonth[i] < steps) {
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
