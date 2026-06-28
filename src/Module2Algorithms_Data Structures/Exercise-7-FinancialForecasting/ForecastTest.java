public class ForecastTest {

    public static void main(String[] args) {
        FinancialForecast forecast = new FinancialForecast();

        System.out.println("========= FINANCIAL FORECAST =========");
        System.out.println();

        double inv1 = 20000.0;
        double rate1 = 0.06;
        int years1 = 4;
        double result1 = forecast.predictFutureValue(inv1, rate1, years1);

        System.out.println("Investment : ₹" + (int) inv1);
        System.out.println();
        System.out.println("Growth Rate : " + (int) (rate1 * 100) + "%");
        System.out.println();
        System.out.println("Years : " + years1);
        System.out.println();
        System.out.println("Predicted Value : ₹" + String.format("%.2f", result1));
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();

        double inv2 = 35000.0;
        double rate2 = 0.09;
        int years2 = 7;
        double result2 = forecast.predictFutureValue(inv2, rate2, years2);

        System.out.println("Investment : ₹" + (int) inv2);
        System.out.println();
        System.out.println("Growth Rate : " + (int) (rate2 * 100) + "%");
        System.out.println();
        System.out.println("Years : " + years2);
        System.out.println();
        System.out.println("Predicted Value : ₹" + String.format("%.2f", result2));
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();

        double inv3 = 60000.0;
        double rate3 = 0.11;
        int years3 = 12;
        double result3 = forecast.predictFutureValue(inv3, rate3, years3);

        System.out.println("Investment : ₹" + (int) inv3);
        System.out.println();
        System.out.println("Growth Rate : " + (int) (rate3 * 100) + "%");
        System.out.println();
        System.out.println("Years : " + years3);
        System.out.println();
        System.out.println("Predicted Value : ₹" + String.format("%.2f", result3));
        System.out.println();
        System.out.println("-----------------------------------------");
        System.out.println();

        double inv0 = 20000.0;
        double rate0 = 0.06;
        int years0 = 0;
        double result0 = forecast.predictFutureValue(inv0, rate0, years0);

        System.out.println("Years = " + years0);
        System.out.println();
        if (result0 == inv0) {
            System.out.println("Predicted Value : Current Investment");
        } else {
            System.out.println("Predicted Value : ₹" + String.format("%.2f", result0));
        }
    }
}
