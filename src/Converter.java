import java.text.DecimalFormat;

class Converter {
    public void distanceTraveled(int saveTotalSteps) {
        DecimalFormat df = new DecimalFormat("###.###");
        double distance = saveTotalSteps / 0.75;
        System.out.println("[!] Пройденная дистанция за месяц: \n" +
                " " + df.format(distance / 1000) + " КМ");
    }
    public void calorieCalculator(int saveTotalSteps) {
        int calories = saveTotalSteps * 50;
        System.out.println("[!] Количество сожженых килокалорий: \n" +
                " " + calories / 1000);
    }
}

