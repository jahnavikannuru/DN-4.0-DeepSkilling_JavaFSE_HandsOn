public class Main{
    public static void main(String[] args) {
        double initialValue = 100.0;
        double[] growthRates = {0.05, 0.03, 0.07};
        int period = 2;
        Recursion obj=new Recursion();
        double[] predictedValues = obj.recursiveGrowthPrediction(initialValue, growthRates, period);
        System.out.print("Initial Value: " + initialValue);
        System.out.println("\nPeriod: " + period);
        System.out.println("Predicted Values:");
        for (double value : predictedValues) {
            System.out.println(value);
        }
    }
}