public class FinancialForecast {

    public double predictFutureValue(double currentValue, double growthRate, int years) {
        if (years <= 0) {
            return currentValue;
        }

        double nextValue = currentValue * (1 + growthRate);

        return predictFutureValue(nextValue, growthRate, years - 1);
    }
}
