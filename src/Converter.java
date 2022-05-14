import java.text.DecimalFormat;

class Converter {
    private final DecimalFormat DF = new DecimalFormat("###.###");
    private final double ONE_STEP_CM = 0.75;
    private final int ONE_STEP_CAL = 50;
    private final int CALORIES = 1000;
    private final int METERS = 1000;

    public String distanceTraveled(int saveTotalSteps) {
        double distance = saveTotalSteps / ONE_STEP_CM;
        return DF.format(distance / METERS);
    }
    public int calorieCalculator(int saveTotalSteps) {
        int calCount = saveTotalSteps * ONE_STEP_CAL;
        return calCount / CALORIES;
    }
}