public class Recursion {
    public double[] recursiveGrowthPrediction(double initialValue, double[] growthRates, int period) {
        double[] predictions = new double[period + 1];
        predictions[0] = initialValue;

        fillPredictions(predictions, growthRates, 1, period);
        return predictions;
    }
    public void fillPredictions(double[] predictions, double[] growthRates, int step, int period) {
        if (step > period) {
            return;
        }

        double currentRate = growthRates[(step - 1) % growthRates.length];
        predictions[step] = predictions[step - 1] * (1 + currentRate);

        fillPredictions(predictions, growthRates, step + 1, period);
    }
}
